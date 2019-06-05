package org.opengroup.archimate.meta.element

import org.opengroup.archimate.meta.layer.Layer
import org.opengroup.archimate.meta.relationship.Relationship
import org.opengroup.archimate.relationship.dependency.{Access, Influence, Serving}
import org.opengroup.archimate.relationship.dynamic.{Flow, Triggering}
import org.opengroup.archimate.relationship.other.{Association, Specialization}
import org.opengroup.archimate.relationship.structural.{Aggregation, Assignment, Composition, Realization}
import org.opengroup.archimate.{IdGenerator, Resource}

import scala.collection.mutable
import scala.compat.Platform.EOL

trait Element {
	val id: String = IdGenerator.next(_fullElementName)
	val name: String
	val desc: String

	val _relationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]
	val _reverseRelationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]

	private def _layerName = Element.this match {
		case layer: Layer =>
			layer._puml
		case _ => ""
	}

	private[archimate] def _elementName = Element.this match {
		case product: Product =>
			product.productPrefix
		case _ => ""
	}

	private def _fullElementName = s"${_layerName}_${_elementName}"

	def relatedElements: Set[Element] = _relationships.map(r => r.dst).toSet ++ _reverseRelationships.map(r => r.dst).toSet

	private[archimate] def relReverse(rel: Relationship): Unit = _reverseRelationships += rel.reverse

	private[archimate] object _rel {
		private def apply[T <: Element](rel: Relationship)(implicit tThis: T): T = {
			JR.assertRelationAllowed(rel)
			_relationships.add(rel)
			rel.dst.relReverse(rel)
			tThis
		}

		def accesses[T <: Element](dst: Element)(implicit tThis: T) = apply(Access(Element.this, dst))

		def influences[T <: Element](dst: Element, label: String)
			(implicit tThis: T) = apply(Influence(Element.this, dst, label))

		def serves[T <: Element](dst: Element)(implicit tThis: T) = apply(Serving(Element.this, dst))

		def flowsTo[T <: Element](dst: Element)(implicit tThis: T) = apply(Flow(Element.this, dst))

		def triggers[T <: Element](dst: Element)(implicit tThis: T) = apply(Triggering(Element.this, dst))

		def associatedWith[T <: Element](dst: Element)(implicit tThis: T) = apply(Association(Element.this, dst))

		def specializationOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Specialization(Element.this, dst))

		def aggregates[T <: Element](dst: Element)(implicit tThis: T) = apply(Aggregation(Element.this, dst))

		def assignedTo[T <: Element](dst: Element)(implicit tThis: T) = apply(Assignment(Element.this, dst))

		def composedOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Composition(Element.this, dst))

		def realizes[T <: Element](dst: Element)(implicit tThis: T) = apply(Realization(Element.this, dst))
	}

	object puml {
		def element: String = {
			val sb = StringBuilder.newBuilder
			val kind = Resource.b.getString(_fullElementName)
			sb.append(_elementName)
			sb.append(s"""($id, "${name.replaceAll("\n", "\\\\n")}\\n($kind)")""")
			sb.mkString
		}

		def relationships: String = Element.this._relationships.map(r => r.puml).mkString(EOL)

		def reverseRelationships: String = Element.this._reverseRelationships.map(r => r.puml).mkString(EOL)
	}

}

trait ElementRelationships[T <: Element] {
	private[archimate] implicit val tt: T

	private[archimate] def _register(traitElement: ElementName, methods: (Method.Value, ElementName)*): Unit = {
		JR.append(traitElement, tt, methods: _*)
	}

	def composedOf(dst: T): T = tt._rel.composedOf(dst)

	def aggregates(dst: T): T = tt._rel.aggregates(dst)

	def specializationOf(dst: T): T = tt._rel.specializationOf(dst)

	private def _doRegister(): Unit = {
		val element = new ElementName {
			override def name: String = tt._elementName
		}

		_register(element,
			JR.composedOf(element),
			JR.aggregates(element),
			JR.specializationOf(element)
		)
	}

	_doRegister()

}