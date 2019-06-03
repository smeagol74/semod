package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{RequirementElement, RequirementElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Requirement(
	name: String,
	desc: String = ""
) extends Motivation
	with RequirementElement {

	object rel extends RequirementElementRelationships[Requirement] {
		override private[archimate] implicit val tt: Requirement = Requirement.this
	}

}
