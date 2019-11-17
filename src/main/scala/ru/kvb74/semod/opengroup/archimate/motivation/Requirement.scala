package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{RequirementElement, RequirementElementProps, RequirementElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Requirement(
	name: String
) extends MotivationLayer
	with RequirementElement {

	case class RequirementRelationships(
		override private[semod] implicit val tt: Requirement = Requirement.this
	) extends RequirementElementRelationships[Requirement]

	val rel: RequirementRelationships = RequirementRelationships()

	case class RequirementProps(
		override private[semod] implicit val tt: Requirement = Requirement.this
	) extends RequirementElementProps[Requirement]

	val prop: RequirementProps = RequirementProps()

	_registerPrefix("MR")
}
