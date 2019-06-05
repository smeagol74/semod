package org.opengroup.archimate.motivation

import org.opengroup.archimate.meta.element.motivation.{AssessmentElement, AssessmentElementRelationships}
import org.opengroup.archimate.meta.layer.Motivation

case class Assessment(
	name: String,
	desc: String = ""
) extends Motivation
	with AssessmentElement {

	case class AssessmentRelationships(
		override private[archimate] implicit val tt: Assessment = Assessment.this
	) extends AssessmentElementRelationships[Assessment]

	val rel: AssessmentRelationships = AssessmentRelationships()

}
