package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{OutcomeElement, OutcomeElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Outcome(
	name: String,
	desc: String = ""
) extends Motivation
	with OutcomeElement {

	case class OutcomeRelationships(
		override private[archimate] implicit val tt: Outcome = Outcome.this
	) extends OutcomeElementRelationships[Outcome]

	val rel: OutcomeRelationships = OutcomeRelationships()

}
