package org.opengroup.archimate.meta.element.relationship

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.layer.Layer

trait Junction
	extends Layer {
	override val _puml = "Junction"
}

trait JunctionElement
	extends Element {
	override val name: String = ""
	override val desc: String = ""
}
