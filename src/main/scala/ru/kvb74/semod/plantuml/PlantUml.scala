package ru.kvb74.semod.plantuml

import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.util.ResourceBundle

import net.sourceforge.plantuml.{FileFormat, FileFormatOption, SourceStringReader}
import ru.kvb74.semod.meta.relationship.dependency.{Access, AccessMode, Influence}
import ru.kvb74.semod.meta.relationship.dynamic.{Flow, Triggering}
import ru.kvb74.semod.meta.relationship.other.Specialization
import ru.kvb74.semod.meta.relationship.structural.{Aggregation, Composition, Realization}
import ru.kvb74.semod.meta.{DirectionHint, Element, Layer, Relationship}
import ru.kvb74.semod.opengroup.archimate.composite.{Grouping, Location}
import ru.kvb74.semod.opengroup.archimate.meta.element.{ActiveStructureElement, BehaviorElement}
import ru.kvb74.semod.opengroup.archimate.meta.layer._
import ru.kvb74.semod.{Report, Resource}

import scala.compat.Platform.EOL
import scala.reflect.io.{File, Path}

object PlantUml {

	private val b = Resource.bundle("opengroup")

	private def _res(bundle: ResourceBundle, key: String): String = {
		if (bundle.containsKey(key))
			bundle.getString(key)
		else
			b.getString(key)
	}

	private def _normalize(text: String): String = text.replaceAll("\n", "\\\\n")

	private def _appendHint(sb: StringBuilder, bundle: ResourceBundle, showHints: Boolean, element: Element) = {
		if (showHints) {
			if (element.name.nonEmpty) {
				sb.append("\\n")
			}
			sb.append(s"""(${_res(bundle, element.fullElementName)})""")
		}
	}

	private def _renderElement(bundle: ResourceBundle, showHints: Boolean, element: Element, layer: String): String = {
		val sb = StringBuilder.newBuilder
		if (!layer.isBlank) {
			sb.append(layer)
			sb.append("_")
			sb.append(element.elementName.replaceFirst(layer, ""))
		} else {
			sb.append(element.elementName)
		}
		sb.append(s"""(${element.id}, "${_normalize(element.name)}""")
		_appendHint(sb, bundle, showHints, element)
		sb.append("\")")
		sb.mkString
	}

	private def _layerName(element: Element): String = element match {
		case layer: Layer =>
			layer.layerName
		case _ =>
			""
	}

	private def renderElement(bundle: ResourceBundle, showHints: Boolean, element: Element): String = element match {
		case _: Grouping => _renderElement(bundle, showHints, element, "")
		case el: Location => _renderElement(bundle, showHints, element, "Other")
		case _ => _renderElement(bundle, showHints, element, _layerName(element))
	}

	private def _relPuml(relationship: Relationship, suff: String = "") =
		s"Rel_${relationship.asInstanceOf[Product].productPrefix}$suff"

	private def _relDesc(bundle: ResourceBundle, relationship: Relationship, puml: String) =
		_res(bundle, puml)

	private def _layerWeight(element: Element) = element match {
		case _: Business => 1
		case _: Application => 2
		case _: Technology => 3
		case _: Physical => 4
		case _: Implementation => 5
		case _ => 0
	}

	private def _aspectWeight(element: Element) = element match {
		case _: ActiveStructureElement => 1
		case _: BehaviorElement => 2
		case _ => 0
	}

	private def _directionForLayers(relationship: Relationship): Option[DirectionHint.Value] = {
		val srcWeight = _layerWeight(relationship.src)
		val dstWeight = _layerWeight(relationship.dst)
		if (srcWeight > 0 && dstWeight > 0 && srcWeight > dstWeight) {
			Some(DirectionHint.UP)
		} else if (srcWeight > 0 && dstWeight > 0 && srcWeight < dstWeight) {
			Some(DirectionHint.DOWN)
		} else {
			None
		}
	}

	private def _directionForRelationship(relationship: Relationship): Option[DirectionHint.Value] = relationship match {
		case _: Triggering => Some(DirectionHint.RIGHT)
		case _: Flow => Some(DirectionHint.RIGHT)
		case _: Specialization => Some(DirectionHint.UP)
		case _: Aggregation => Some(DirectionHint.DOWN)
		case _: Composition => Some(DirectionHint.DOWN)
		case _: Realization => Some(DirectionHint.UP)
		case _ => None
	}

	private def _directionForAspect(relationship: Relationship): Option[DirectionHint.Value] = {
		val srcWeight = _aspectWeight(relationship.src)
		val dstWeight = _aspectWeight(relationship.dst)
		if (srcWeight > 0 && dstWeight > 0 && srcWeight > dstWeight) {
			Some(DirectionHint.LEFT)
		} else if (srcWeight > 0 && dstWeight > 0 && srcWeight < dstWeight) {
			Some(DirectionHint.RIGHT)
		} else {
			None
		}
	}

	private def _directionAuto(relationship: Relationship) =
		_directionForLayers(relationship)
			.orElse(_directionForRelationship(relationship))
			.orElse(_directionForAspect(relationship))
			.getOrElse(DirectionHint.NONE)

	private def _directionHint(dir: DirectionHint.Value) = dir match {
		case DirectionHint.NONE => ""
		case DirectionHint.UP => "_Up"
		case DirectionHint.DOWN => "_Down"
		case DirectionHint.LEFT => "_Left"
		case DirectionHint.RIGHT => "_Right"
	}

	private def _directionHint(relationship: Relationship): String = relationship.dir match {
		case DirectionHint.AUTO => _directionHint(_directionAuto(relationship))
		case _ => _directionHint(relationship.dir)
	}

	private def _renderRelationship(relationship: Relationship, puml: String, desc: String): String = {
		val sb = StringBuilder.newBuilder
		sb.append(puml)
		sb.append(_directionHint(relationship))
		sb.append(s"""(${relationship.src.id}, ${relationship.dst.id}, "$desc")""")
		sb.mkString
	}

	private def _relHint(standalone: Boolean,
		bundle: ResourceBundle,
		showHints: Boolean,
		relationship: Relationship,
		puml: String): String = {
		if (showHints) {
			if (standalone)
				_relDesc(bundle, relationship, puml)
			else
				s"\\n(${_relDesc(bundle, relationship, puml)})"
		} else {
			""
		}
	}

	private def _renderInfluence(bundle: ResourceBundle, showHints: Boolean, relationship: Influence): String = {
		val puml = _relPuml(relationship)
		val desc = _relHint(relationship.label.isBlank, bundle, showHints, relationship, puml)
		_renderRelationship(relationship, puml, s"${relationship.label.trim}$desc")
	}

	private def _renderGeneric(bundle: ResourceBundle, showHints: Boolean, relationship: Relationship): String = {
		val puml = _relPuml(relationship)
		val desc = _relHint(standalone = true, bundle, showHints = showHints, relationship, puml)
		_renderRelationship(relationship, puml, desc)
	}

	private def _renderAccess(bundle: ResourceBundle, showHints: Boolean, relationship: Access): String = {
		val puml = relationship.mode match {
			case AccessMode.NONE => _relPuml(relationship)
			case AccessMode.READ => _relPuml(relationship, "_r")
			case AccessMode.WRITE => _relPuml(relationship, "_w")
			case AccessMode.READ_WRITE => _relPuml(relationship, "_rw")
		}
		val desc = _relHint(standalone = true, bundle, showHints = showHints, relationship, puml)
		_renderRelationship(relationship, puml, desc)
	}

	private def _renderFlow(bundle: ResourceBundle, showHints: Boolean, relationship: Flow): String = {
		val puml = _relPuml(relationship)
		val desc = _relHint(relationship.label.isBlank, bundle, showHints, relationship, puml)
		_renderRelationship(relationship, puml, s"${relationship.label.trim}$desc")
	}


	private def renderRelationship(bundle: ResourceBundle,
		showHints: Boolean,
		relationship: Relationship): String = relationship match {
		case rel: Influence => _renderInfluence(bundle, showHints, rel)
		case rel: Access => _renderAccess(bundle, showHints, rel)
		case rel: Flow => _renderFlow(bundle, showHints, rel)
		case _ => _renderGeneric(bundle, showHints, relationship)
	}

	/**
		* Настройки отчёта PlantUML
		*/
	trait Options {
		/**
			* Название отчёта
			*/
		val name: Option[String]
		/**
			* Заголовок отчёта
			*/
		val title: Option[String]
		/**
			* Верхний колонтитул
			*/
		val header: Option[String]
		/**
			* Нижний колонтитул
			*/
		val footer: Option[String]
		/**
			* Имя файла в который нужно выгрузить результат. Возможные расширения файла:
			* * .png — растровый файл в формате PNG
			* * .svg — векторный файл в формате SVG
			* * любой другой — текстовый файл в формате .puml
			*/
		val file: Option[String]
		/**
			* Название ресурса с терминологией файл "archimate/${terms}.properties"
			*/
		val terms: String
		/**
			* Если True то добавлять названия элементов и отношений на диаграммы
			*/
		val showHints: Boolean
	}

	class OptionsBuilder {
		private var _name: Option[String] = None
		private var _title: Option[String] = None
		private var _header: Option[String] = None
		private var _footer: Option[String] = None
		private var _file: Option[String] = None
		private var _terms: String = "opengroup"
		private var _showHints: Boolean = true

		def name(value: String): OptionsBuilder = {
			_name = Some(value)
			this
		}

		def name(value: Option[String]): OptionsBuilder = {
			_name = value
			this
		}

		def title(value: String): OptionsBuilder = {
			_title = Some(value)
			this
		}

		def title(value: Option[String]): OptionsBuilder = {
			_title = value
			this
		}

		def header(value: String): OptionsBuilder = {
			_header = Some(value)
			this
		}

		def header(value: Option[String]): OptionsBuilder = {
			_header = value
			this
		}

		def footer(value: String): OptionsBuilder = {
			_footer = Some(value)
			this
		}

		def footer(value: Option[String]): OptionsBuilder = {
			_footer = value
			this
		}

		def file(value: String): OptionsBuilder = {
			_file = Some(value)
			this
		}

		def file(value: Option[String]): OptionsBuilder = {
			_file = value
			this
		}

		def terms(value: String): OptionsBuilder = {
			_terms = value
			this
		}

		def showHints(value: Boolean): OptionsBuilder = {
			_showHints = value
			this
		}

		def get: Options = OptionsInstance(_name, _title, _header, _footer, _file, _terms, _showHints)
	}

	/**
		* Создаёт пустой построитель настроек
		*
		* @return
		*/
	def opt = new OptionsBuilder

	case class OptionsInstance(
		name: Option[String],
		title: Option[String],
		header: Option[String],
		footer: Option[String],
		file: Option[String],
		terms: String,
		showHints: Boolean
	) extends Options

	private def renderToString(
		options: Options,
		elements: Set[Element],
		relationships: Set[Relationship]
	): String = {
		val bundle = Resource.bundle(options.terms)
		val sb = StringBuilder.newBuilder
		sb.append("@startuml")
		options.name.foreach(name => sb.append(s" $name"))
		sb.append(EOL)
		sb.append("!include https://raw.githubusercontent.com/smeagol74/semod-plantuml/master/dist/semod.puml").append(EOL).append(EOL)

		options.header.foreach(header => sb.append(s"header ${_normalize(header)}").append(EOL).append(EOL))
		options.footer.foreach(footer => sb.append(s"footer ${_normalize(footer)}").append(EOL).append(EOL))
		options.title.foreach(title => sb.append(s"title ${_normalize(title)}").append(EOL).append(EOL))

		elements.toList.sortBy(_.id).map(renderElement(bundle, options.showHints, _)).foreach(sb.append(_).append(EOL))
		relationships.toList.sortBy(_.id).map(renderRelationship(bundle, options.showHints, _)).foreach(sb.append(_).append(EOL))

		sb.append("@enduml").append(EOL)
		sb.mkString
	}

	private object r {
		val png = ".*\\.png$".r
		val svg = ".*\\.svg$".r
	}

	/**
		* Если указана настройка `file`, то результат будет записан в файл, если же такая настройка не указана,
		* то текст в формате plant-uml будет возвращён в виде строки
		*/
	def render(
		options: Options,
		report: Report
	): String = {
		val source = renderToString(options, report.elements, report.relationships)
		options.file match {
			case Some(filePath) =>
				val file = File(Path(filePath))
				val ext = filePath.toLowerCase
				if (ext.matches(".*\\.png")) {
					val reader = new SourceStringReader(source)
					reader.outputImage(file.jfile)
				} else if (ext.matches(".*\\.svg")) {
					val reader = new SourceStringReader(source)
					val os = new ByteArrayOutputStream()
					reader.generateImage(os, new FileFormatOption(FileFormat.SVG))
					os.close()
					val svg = new String(os.toByteArray, Charset.forName("UTF-8"))
					file.writeAll(svg)
				} else {
					file.writeAll(source)
				}
				filePath
			case None =>
				source
		}
	}

}
