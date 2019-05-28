package org.opengroup.archimate.element

import org.opengroup.archimate.Resource
import org.opengroup.archimate.layer.Layer
import org.opengroup.archimate.relationships.Relationship
import org.opengroup.archimate.relationships.dependency.{Access, Influence, Serving}
import org.opengroup.archimate.relationships.dynamic.{Flow, Triggering}
import org.opengroup.archimate.relationships.other.{Association, Specialization}
import org.opengroup.archimate.relationships.structural.{Aggregation, Assignment, Composition, Realization}

import scala.collection.mutable
import scala.compat.Platform.EOL

trait Element {
	val id: String
	val name: String
	val desc: String

	val _relationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]
	val _reverseRelationships: mutable.HashSet[Relationship] = mutable.HashSet.empty[Relationship]

	def relatedElements: Set[Element] = _relationships.map(r => r.dst).toSet ++ _reverseRelationships.map(r => r.dst).toSet

	private[archimate] def relReverse(rel: Relationship): Unit = _reverseRelationships += rel.reverse

	private[archimate] object _rel {
		private def apply[T <: Element](rel: Relationship)(implicit tThis: T): T = {
			_relationships.add(rel)
			rel.dst.relReverse(rel)
			tThis
		}

		def accesses[T <: Element](dst: Element)(implicit tThis: T) = apply(Access(Element.this, dst))

		def influences[T <: Element](dst: Element, label: String)(implicit tThis: T) = apply(Influence(Element.this, dst, label))

		def serves[T <: Element](dst: Element)(implicit tThis: T) = apply(Serving(Element.this, dst))

		def flowsTo[T <: Element](dst: Element)(implicit tThis: T) = apply(Flow(Element.this, dst))

		def triggers[T <: Element](dst: Element)(implicit tThis: T) = apply(Triggering(Element.this, dst))

		def associatedWith[T <: Element](dst: Element)(implicit tThis: T) = apply(Association(Element.this, dst))

		def isSpecializationOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Specialization(Element.this, dst))

		def aggregates[T <: Element](dst: Element)(implicit tThis: T) = apply(Aggregation(Element.this, dst))

		def assignedTo[T <: Element](dst: Element)(implicit tThis: T) = apply(Assignment(Element.this, dst))

		def isComposedOf[T <: Element](dst: Element)(implicit tThis: T) = apply(Composition(Element.this, dst))

		def realizes[T <: Element](dst: Element)(implicit tThis: T) = apply(Realization(Element.this, dst))
	}

	object puml {
		def element: String = {
			val sb = StringBuilder.newBuilder
			var layer = ""
			if (Element.this.isInstanceOf[Layer]) {
				layer = Element.this.asInstanceOf[Layer]._puml
				sb.append(layer)
				sb.append("_")
			}
			val kind = Resource.b.getString(s"${layer}_${Element.this.asInstanceOf[Product].productPrefix}")
			sb.append(Element.this.asInstanceOf[Product].productPrefix)
			sb.append(s"""($id, "${name.replaceAll("\n", "\\\\n")}\\n($kind)")""")
			sb.mkString
		}

		def relationships: String = Element.this._relationships.map(r => r.puml).mkString(EOL)

		def reverseRelationships: String = Element.this._reverseRelationships.map(r => r.puml).mkString(EOL)
	}

}

trait ElementRelationships[T <: Element] {

	private[archimate] implicit val tt: T

	def isComposedOf(dst: T): T = tt._rel.isComposedOf(dst)

	def aggregates(dst: T): T = tt._rel.aggregates(dst)

	def isSpecializationOf(dst: T): T = tt._rel.isSpecializationOf(dst)
}