package org.opengroup.archimate.meta.element.motivation

import org.opengroup.archimate.meta.element.{ActiveStructureElement, ElementRelationships}

trait StakeholderElement
	extends ActiveStructureElement

trait StakeholderElementRelationships[T <: StakeholderElement]
	extends ElementRelationships[T] {
	def influences(dst: StakeholderElement, label: String = ""): T = tt._rel.influences(dst, label)

	def associatedWith(dst: MotivationElement): T = tt._rel.associatedWith(dst)
}
