package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait ImplementationEventElement
	extends Element

trait ImplementationEventElementRelationships[T <: ImplementationEventElement]
	extends ElementRelationships[T]
