package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait PlateauElement
	extends Element

trait PlateauElementRelationships[T <: PlateauElement]
	extends ElementRelationships[T]

