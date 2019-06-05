package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait PlateauElement
	extends Element

case object PlateauElement
	extends ElementName

trait PlateauElementRelationships[T <: PlateauElement]
	extends ElementRelationships[T] {

	_register(PlateauElement)

}

