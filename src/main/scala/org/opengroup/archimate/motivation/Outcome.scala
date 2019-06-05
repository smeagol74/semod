package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{OutcomeElement, OutcomeElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

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
