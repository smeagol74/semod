package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{OutcomeElement, OutcomeElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Outcome(
	name: String,
	desc: String = ""
) extends MotivationLayer
	with OutcomeElement {

	case class OutcomeRelationships(
		override private[semod] implicit val tt: Outcome = Outcome.this
	) extends OutcomeElementRelationships[Outcome]

	val rel: OutcomeRelationships = OutcomeRelationships()

	_registerPrefix("MO")
}
