package org.opengroup.archimate.meta.element

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.meta.element.relationship.JunctionElement
import org.opengroup.archimate.meta.layer.Layer
import org.opengroup.archimate.meta.relationship.{JunctionMethod, JunctionMode, JunctionSrc, Relationship}
import org.opengroup.archimate.relationship.dependency.{Access, AccessMode, Influence, Serving}
import org.opengroup.archimate.relationship.dynamic.{Flow, Triggering}
import org.opengroup.archimate.relationship.other.{Association, Specialization}
import org.opengroup.archimate.relationship.structural.{Aggregation, Assignment, Composition, Realization}

import scala.collection.mutable

trait Element {
	val id: String = IdGenerator.next(fullElementName)
	val name: String
	val desc: String

	val _relationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]
	val _reverseRelationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]

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

	private[archimate] def relReverse(rel: Relationship): Unit = _reverseRelationships += rel.reverse

	private[archimate] object _rel {
		private def apply[T <: Element](rel: Relationship)(implicit tThis: T): T = {
			if (!rel.src.isInstanceOf[JunctionElement] && !rel.dst.isInstanceOf[JunctionElement]) {
				JR.assertRelationAllowed(rel)
			}
			_relationships.add(rel)
			rel.dst.relReverse(rel)
			tThis
		}

		def accesses[T <: Element](dst: Element, mode: AccessMode.Value)
			(implicit tThis: T) = apply(Access(Element.this, dst, mode))

		def influences[T <: Element](dst: Element, label: String)
			(implicit tThis: T) = apply(Influence(Element.this, dst, label))

		def serves[T <: Element](dst: Element)(implicit tThis: T) = apply(Serving(Element.this, dst))

		def flowsTo[T <: Element](dst: Element, label: String)(implicit tThis: T) = apply(Flow(Element.this, dst, label))

		def triggers[T <: Element](dst: Element)(implicit tThis: T) = apply(Triggering(Element.this, dst))

		def associatedWith[T <: Element](dst: Element)(implicit tThis: T) = apply(Association(Element.this, dst))

		def specializationOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Specialization(Element.this, dst))

		def aggregates[T <: Element](dst: Element)(implicit tThis: T) = apply(Aggregation(Element.this, dst))

		def assignedTo[T <: Element](dst: Element)(implicit tThis: T) = apply(Assignment(Element.this, dst))

		def composedOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Composition(Element.this, dst))

		def realizes[T <: Element](dst: Element)(implicit tThis: T) = apply(Realization(Element.this, dst))

		def apply[T <: Element](method: Method.Value, dst: Element): T = method match {
			case Method.accesses => apply(Access(Element.this, dst, AccessMode.NONE))(Element.this.asInstanceOf[T])
			case Method.influences => apply(Influence(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.serves => apply(Serving(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.flowsTo => apply(Flow(Element.this, dst, ""))(Element.this.asInstanceOf[T])
			case Method.triggers => apply(Triggering(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.associatedWith => apply(Association(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.specializationOf => apply(Specialization(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.aggregates => apply(Aggregation(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.assignedTo => apply(Assignment(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.composedOf => apply(Composition(Element.this, dst))(Element.this.asInstanceOf[T])
			case Method.realizes => apply(Realization(Element.this, dst))(Element.this.asInstanceOf[T])
		}
	}

}

case class JunctionMethodThis[T <: Element](tt: T, method: Method.Value) {
	def and(dst: Element*): T = {
		JunctionMethod(JunctionSrc(JunctionMode.AND, tt), method).and(dst: _*)
		tt
	}

	def or(dst: Element*): T = {
		JunctionMethod(JunctionSrc(JunctionMode.AND, tt), method).or(dst: _*)
		tt
	}
}

case class JunctionSrcThis[T <: Element](tt: T, mode: JunctionMode.Value, src: Element*) {
	def accessesThis: T = {
		JunctionSrc(mode, src: _*).accesses.and(tt)
		tt
	}

	def influencesThis: T = {
		JunctionSrc(mode, src: _*).influences.and(tt)
		tt
	}

	def servesThis: T = {
		JunctionSrc(mode, src: _*).serves.and(tt)
		tt
	}

	def flowsToThis: T = {
		JunctionSrc(mode, src: _*).flowsTo.and(tt)
		tt
	}

	def triggersThis: T = {
		JunctionSrc(mode, src: _*).triggers.and(tt)
		tt
	}

	def associatedWithThis: T = {
		JunctionSrc(mode, src: _*).associatedWith.and(tt)
		tt
	}

	def specializationOfThis: T = {
		JunctionSrc(mode, src: _*).specializationOf.and(tt)
		tt
	}

	def aggregatesThis: T = {
		JunctionSrc(mode, src: _*).aggregates.and(tt)
		tt
	}

	def assignedToThis: T = {
		JunctionSrc(mode, src: _*).assignedTo.and(tt)
		tt
	}

	def composedOfThis: T = {
		JunctionSrc(mode, src: _*).composedOf.and(tt)
		tt
	}

	def realizesThis: T = {
		JunctionSrc(mode, src: _*).realizes.and(tt)
		tt
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

	private def _doRegister(): Unit = {
		val element = new ElementName {
			override def name: String = tt.elementName
		}

		_register(element,
			JR.composedOf(element),
			JR.aggregates(element),
			JR.specializationOf(element)
		)
	}

	_doRegister()

}