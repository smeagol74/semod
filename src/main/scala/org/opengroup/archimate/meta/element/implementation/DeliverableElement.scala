package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait DeliverableElement
	extends Element

trait DeliverableElementRelationships[T <: DeliverableElement]
	extends ElementRelationships[T]