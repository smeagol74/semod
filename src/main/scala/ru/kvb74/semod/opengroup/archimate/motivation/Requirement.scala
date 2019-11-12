package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{RequirementElement, RequirementElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Requirement(
	name: String,
	desc: String = ""
) extends Motivation
	with RequirementElement {

	case class RequirementRelationships(
		override private[semod] implicit val tt: Requirement = Requirement.this
	) extends RequirementElementRelationships[Requirement]

	val rel: RequirementRelationships = RequirementRelationships()

	_registerPrefix("MR")
}
