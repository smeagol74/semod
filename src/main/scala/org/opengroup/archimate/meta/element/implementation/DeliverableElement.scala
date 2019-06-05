package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait DeliverableElement
	extends Element

case object DeliverableElement
	extends ElementName

trait DeliverableElementRelationships[T <: DeliverableElement]
	extends ElementRelationships[T] {

	_register(DeliverableElement)

}