package org.opengroup.archimate.meta.element.business

import org.opengroup.archimate.meta.element.{Element, ElementRelationships}

trait BusinessPassiveStructureElement
	extends Element

trait BusinessPassiveStructureElementRelationships[T <: BusinessPassiveStructureElement]
	extends ElementRelationships[T]