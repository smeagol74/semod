package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait GapElement
	extends Element

trait GapElementRelationships[T <: GapElement]
	extends ElementRelationships[T]
