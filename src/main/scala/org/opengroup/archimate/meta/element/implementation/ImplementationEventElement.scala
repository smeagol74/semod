package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait ImplementationEventElement
	extends Element

case object ImplementationEventElement
	extends ElementName

trait ImplementationEventElementRelationships[T <: ImplementationEventElement]
	extends ElementRelationships[T] {

	_register(ImplementationEventElement)

}
