package ru.kvb74.semod.omg.essence.meta.element

import ru.kvb74.semod.Resource
import ru.kvb74.semod.meta.{DirectionHint, ElementName}

trait WorkProductElement	
	extends EssenceElement

case object WorkProductElement
	extends ElementName

trait WorkProductElementProps[T <: WorkProductElement]
	extends EssenceElementProps[T]

trait WorkProductElementRelationships[T <: WorkProductElement]
	extends EssenceElementRelationships[T] {

	def _describes(dst: AlphaElement, dir: DirectionHint.Value=DirectionHint.UP): T = __(dst, "Essence_WorkProduct_Rel_description", dir)
	def _evidences(dst: AlphaStateElement, dir: DirectionHint.Value=DirectionHint.UP): T = __(dst, "Essence_WorkProduct_Rel_evidence", dir)

	_register(WorkProductElement)
}

