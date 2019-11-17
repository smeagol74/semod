package ru.kvb74.semod.meta

import java.util

import ru.kvb74.semod.DB
import ru.kvb74.semod.meta.relationship.dependency.{Access, AccessMode, Influence, Serving}
import ru.kvb74.semod.meta.relationship.dynamic.{Flow, Triggering}
import ru.kvb74.semod.meta.relationship.junction.JunctionElement
import ru.kvb74.semod.meta.relationship.other.{Association, Specialization}
import ru.kvb74.semod.meta.relationship.structural.{Aggregation, Assignment, Composition, Realization}

import scala.collection.mutable

trait Element {
	val id: String = IdGenerator.next(fullElementName)
	val name: String

	private[semod] val _relationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]
	private[semod] val _reverseRelationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]
	private[semod] val _props: mutable.HashMap[ElementProps.Param, Any] = mutable.HashMap.empty[ElementProps.Param, Any]

	object props {
		def asString(key: ElementProps.Param): Option[String] = _props.get(key).flatMap(_ match {
			case str: String => Some(str)
			case _ => None
		})

		def asInt(key: ElementProps.Param): Option[Int] = _props.get(key).flatMap(_ match {
			case str: Int => Some(str)
			case _ => None
		})

		def asBool(key: ElementProps.Param): Option[Boolean] = _props.get(key).flatMap(_ match {
			case str: Boolean => Some(str)
			case _ => None
		})

		def asStringSet(key: ElementProps.Param): Option[Set[String]] = _props.get(key).flatMap(_ match {
			case res: Set[String] => Some(res)
			case _ => None
		})
	}

	override def equals(obj: Any): Boolean = {
		obj match {
			case element: Element =>
				id.equals(element.id)
			case _ =>
				super.equals(obj)
		}
	}

	override def toString: String = Element.this match {
		case product: Product =>
			val sb = StringBuilder.newBuilder
			sb.append(product.productPrefix)
			sb.append("(")
			sb.append(id)
			if (product.productArity > 0) {
				sb.append(",")
			}
			sb.append(product.productIterator.mkString(","))
			sb.append(")")
			sb.mkString
		case _ => super.toString
	}

	def elementName: String = Element.this match {
		case product: Product =>
			product.productPrefix
		case _ => ""
	}

	def fullElementName: String = this match {
		case layer: Layer =>
			s"${layer.layerName}_$elementName"
		case _ => elementName
	}

	def relatedElements: Set[Element] = _relationships.map(r => r.src).toSet ++
		_relationships.map(r => r.dst).toSet ++
		_reverseRelationships.map(r => r.src).toSet ++
		_reverseRelationships.map(r => r.dst).toSet

	private[semod] def _registerPrefix(prefix: String): Unit = IdGenerator.registerPrefix(fullElementName, prefix)

	private[semod] def relReverse(rel: Relationship): Unit = _reverseRelationships += rel

	private[semod] object _rel {
		private def apply[T <: Element](rel: Relationship)(implicit tThis: T): T = {
			if (!rel.src.isInstanceOf[JunctionElement] && !rel.dst.isInstanceOf[JunctionElement]) {
				RR.assertRelationAllowed(rel)
			}
			_relationships.add(rel)
			rel.dst.relReverse(rel)
			tThis
		}

		def accesses[T <: Element](dst: Element, mode: AccessMode.Value, dir: DirectionHint.Value = DirectionHint.AUTO)
			(implicit tThis: T) = apply(Access(Element.this, dst, dir, mode))

		def influences[T <: Element](dst: Element, label: String, dir: DirectionHint.Value = DirectionHint.AUTO)
			(implicit tThis: T) = apply(Influence(Element.this, dst, dir, label))

		def serves[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Serving(Element.this, dst, dir))

		def flowsTo[T <: Element](dst: Element, label: String, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Flow(Element.this, dst, dir, label))

		def triggers[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Triggering(Element.this, dst, dir))

		def associatedWith[T <: Element](dst: Element, label: String, dir: DirectionHint.Value = DirectionHint.AUTO)
			(implicit tThis: T) = apply(Association(Element.this, dst, dir, label))

		def specializationOf[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Specialization(Element.this, dst, dir))

		def aggregates[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Aggregation(Element.this, dst, dir))

		def assignedTo[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Assignment(Element.this, dst, dir))

		def composedOf[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Composition(Element.this, dst, dir))

		def realizes[T <: Element](dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO)(implicit tThis: T) = apply(Realization(Element.this, dst, dir))

		def add[T <: Element](method: Method.Value, dst: Element)(dir: DirectionHint.Value): T = method match {
			case Method.accesses => apply(Access(Element.this, dst, dir, AccessMode.NONE))(Element.this.asInstanceOf[T])
			case Method.influences => apply(Influence(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.serves => apply(Serving(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.flowsTo => apply(Flow(Element.this, dst, dir, ""))(Element.this.asInstanceOf[T])
			case Method.triggers => apply(Triggering(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.associatedWith => apply(Association(Element.this, dst, dir, ""))(Element.this.asInstanceOf[T])
			case Method.specializationOf => apply(Specialization(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.aggregates => apply(Aggregation(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.assignedTo => apply(Assignment(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.composedOf => apply(Composition(Element.this, dst, dir))(Element.this.asInstanceOf[T])
			case Method.realizes => apply(Realization(Element.this, dst, dir))(Element.this.asInstanceOf[T])
		}
	}

	DB.register(Element.this)

}

case class JunctionMethodThis[T <: Element](tt: T, method: Method.Value) {
	def and(dst: Element*)(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionMethod(JunctionSrc(JunctionMode.AND, tt), method).and(dst: _*)(dir)
		tt
	}

	def or(dst: Element*)(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionMethod(JunctionSrc(JunctionMode.AND, tt), method).or(dst: _*)(dir)
		tt
	}
}

case class JunctionSrcThis[T <: Element](tt: T, mode: JunctionMode.Value, src: Element*) {
	def accessesThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).accesses.and(tt)(dir)
		tt
	}

	def influencesThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).influences.and(tt)(dir)
		tt
	}

	def servesThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).serves.and(tt)(dir)
		tt
	}

	def flowsToThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).flowsTo.and(tt)(dir)
		tt
	}

	def triggersThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).triggers.and(tt)(dir)
		tt
	}

	def associatedWithThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).associatedWith.and(tt)(dir)
		tt
	}

	def specializationOfThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).specializationOf.and(tt)(dir)
		tt
	}

	def aggregatesThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).aggregates.and(tt)(dir)
		tt
	}

	def assignedToThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).assignedTo.and(tt)(dir)
		tt
	}

	def composedOfThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).composedOf.and(tt)(dir)
		tt
	}

	def realizesThis(dir: DirectionHint.Value = DirectionHint.AUTO): T = {
		JunctionSrc(mode, src: _*).realizes.and(tt)(dir)
		tt
	}
}

trait ElementRelationships[T <: Element] {
	private[semod] implicit val tt: T

	private[semod] def _register(traitElement: ElementName, methods: (Method.Value, ElementName)*): Unit = {
		RR.append(traitElement, tt, methods: _*)
	}

	/**
		* Универсальный метод для добавления отношений с контролем типов на этапе выполнения и возможностью задать направление линии
		*
		* Universal add relationship method with runtime type control and ability to specify rendering direction hint
		*/
	def add(method: Method.Value, dst: Element, dir: DirectionHint.Value = DirectionHint.AUTO): T = tt._rel.add(method, dst)(dir)

	object junction {
		def accesses: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.accesses)

		def influences: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.influences)

		def serves: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.serves)

		def flowsTo: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.flowsTo)

		def triggers: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.triggers)

		def associatedWith: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.associatedWith)

		def specializationOf: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.specializationOf)

		def aggregates: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.aggregates)

		def assignedTo: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.assignedTo)

		def composedOf: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.composedOf)

		def realizes: JunctionMethodThis[T] = JunctionMethodThis(tt, Method.realizes)

		def and(src: Element*): JunctionSrcThis[T] = JunctionSrcThis(tt, JunctionMode.AND, src: _*)

		def or(src: Element*): JunctionSrcThis[T] = JunctionSrcThis(tt, JunctionMode.OR, src: _*)
	}

	def composedOf(dst: T): T = tt._rel.composedOf(dst)

	def aggregates(dst: T): T = tt._rel.aggregates(dst)

	def specializationOf(dst: T): T = tt._rel.specializationOf(dst)

	def associatedWith(dst: Element, label: String = ""): T = tt._rel.associatedWith(dst, label)

	private def _doRegister(): Unit = {
		val element = new ElementName {
			override def name: String = tt.elementName
		}

		_register(element,
			RR.composedOf(element),
			RR.aggregates(element),
			RR.specializationOf(element)
		)

		_register(Element,
			RR.associatedWith(Element)
		)
	}

	_doRegister()

}

trait ElementProps[T <: Element] {

	private[semod] implicit val tt: T

	/**
		* Element description. Markdown formatting could be used.
		*
		* Описание элемента. Для форматирования можно использовать markdown
		*/
	def desc: Option[String] = tt.props.asString(ElementProps.desc)

	/**
		* Element description. Markdown formatting could be used.
		*
		* Описание элемента. Для форматирования можно использовать markdown
		*/
	def desc(value: String): T = {
		tt._props.getOrElseUpdate(ElementProps.desc, value)
		tt
	}

	/**
		* Link. In SVG report element will be wrapped with http link.
		*
		* Ссылка. При выгрузке в SVG формат, этот элемент будет обёрнут в http ссылку.
		*/
	def link: Option[String] = tt.props.asString(ElementProps.link)

	/**
		* Link. In SVG report element will be wrapped with http link.
		*
		* Ссылка. При выгрузке в SVG формат, этот элемент будет обёрнут в http ссылку.
		*/
	def link(value: String): T = {
		tt._props.getOrElseUpdate(ElementProps.link, value)
		tt
	}

	/**
		* Custom tooltip for SVG. Will be used only if `link` is specified.
		*
		* Специальная подсказка для SVG. Будет использоваться только вместе со ссылкой `link`.
		*/
	def tooltip: Option[String] = tt.props.asString(ElementProps.tooltip)

	/**
		* Custom tooltip for SVG. Will be used only if `link` is specified.
		*
		* Специальная подсказка для SVG. Будет использоваться только вместе со ссылкой `link`.
		*/
	def tooltip(value: String): T = {
		tt._props.getOrElseUpdate(ElementProps.tooltip, value)
		tt
	}

	/**
		* Set of custom tags. Could be used for selects of specific elements on report.
		*
		* Набор текстовых меток. Может быть использовано для выборки необходимых элементов для отчёта.
		*/
	def tags: Set[String] = {
		tt.props.asStringSet(ElementProps.tags) match {
			case Some(res) => res
			case None => Set()
		}
	}

	/**
		* Set of custom tags. Could be used for selects of specific elements on report.
		*
		* Набор текстовых меток. Может быть использовано для выборки необходимых элементов для отчёта.
		*/
	def tags(tags: String*): T = {
		tt._props.getOrElseUpdate(ElementProps.tags, tags.map(_.toLowerCase).toSet)
		tt
	}

}

object ElementProps {

	sealed trait Param

	case object desc extends Param

	case object link extends Param

	case object tooltip extends Param

	case object tags extends Param

}

case object Element
	extends ElementName