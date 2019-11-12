package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{StakeholderElement, StakeholderElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Stakeholder(
	name: String,
	desc: String = ""
) extends Motivation
	with StakeholderElement {

	case class StakeholderRelationships(
		override private[semod] implicit val tt: Stakeholder = Stakeholder.this
	) extends StakeholderElementRelationships[Stakeholder]

	val rel: StakeholderRelationships = StakeholderRelationships()

	_registerPrefix("MS")
}