package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{StakeholderElement, StakeholderElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Stakeholder(
	name: String,
	desc: String = ""
) extends Motivation
	with StakeholderElement {

	object rel extends StakeholderElementRelationships[Stakeholder] {
		override private[archimate] implicit val tt: Stakeholder = Stakeholder.this
	}

}