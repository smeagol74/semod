package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element.{BehaviorElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ApplicationFunctionElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement
		with ApplicationInternalBehaviorElement

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946064
	*/
trait ApplicationFunctionElementRelationships[T <: ApplicationFunctionElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with ApplicationInternalBehaviorElementRelationships[T]
