package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._

trait ApplicationInteractionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with ApplicationInternalBehaviorElement

case object ApplicationInteractionElement
	extends ElementName

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationInteractionElementRelationships[T <: ApplicationInteractionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with ApplicationInternalBehaviorElementRelationships[T] {

	_register(ApplicationInteractionElement)

}
