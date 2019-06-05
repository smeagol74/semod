package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait GapElement
	extends Element

case object GapElement
	extends ElementName

trait GapElementRelationships[T <: GapElement]
	extends ElementRelationships[T] {

	_register(GapElement)

}
