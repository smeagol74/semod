package org.opengroup.archimate.meta.element.implementation

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait WorkPackageElement
	extends Element

trait WorkPackageElementRelationships[T <: WorkPackageElement]
	extends ElementRelationships[T]
