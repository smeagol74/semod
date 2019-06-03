package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{OutcomeElement, OutcomeElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Outcome(
	name: String,
	desc: String = ""
) extends Motivation
	with OutcomeElement {

	object rel extends OutcomeElementRelationships[Outcome] {
		override private[archimate] implicit val tt: Outcome = Outcome.this
	}

}
