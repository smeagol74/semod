package org.opengroup.archimate.relationship.dependency

import org.opengroup.archimate.Resource
import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.DependencyRelationship

case class Influence(
	src: Element,
	dst: Element,
	label: String = "",
	direct: Boolean = true
) extends DependencyRelationship {
	override def reverse = Influence(dst, src, label, direct = false)
	override def puml: String = {
		val sb = StringBuilder.newBuilder
		val name = s"Rel_${this.asInstanceOf[Product].productPrefix}"
		val desc = Resource.b.getString(if (direct) name else s"${name}_back")
		val label = if (this.label.isEmpty) "" else s" (${this.label})"
		sb.append(name)
		sb.append(s"""(${src.id}, ${dst.id}, "$desc$label")""")
		sb.mkString
	}

}
