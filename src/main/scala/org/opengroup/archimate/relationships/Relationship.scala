package org.opengroup.archimate.relationships

import org.opengroup.archimate.Resource
import org.opengroup.archimate.element.Element

trait Relationship {
	val src: Element
	val dst: Element
	val direct: Boolean

	def puml: String = {
		val sb = StringBuilder.newBuilder
		val name = s"Rel_${this.asInstanceOf[Product].productPrefix}"
		val desc = Resource.b.getString(if (direct) name else s"${name}_back")
		sb.append(name)
		sb.append(s"""(${src.id}, ${dst.id}, "$desc")""")
		sb.mkString
	}

	def reverse: Relationship = this
}
