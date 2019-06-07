package ru.kvb74.semod.opengroup.archimate.meta.element.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, ElementName, ElementRelationships}

trait WorkPackageElement
	extends Element

case object WorkPackageElement
	extends ElementName

trait WorkPackageElementRelationships[T <: WorkPackageElement]
	extends ElementRelationships[T] {

	_register(WorkPackageElement)

}
