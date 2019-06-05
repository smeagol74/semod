package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait WorkPackageElement
	extends Element

case object WorkPackageElement
	extends ElementName

trait WorkPackageElementRelationships[T <: WorkPackageElement]
	extends ElementRelationships[T] {

	_register(WorkPackageElement)

}
