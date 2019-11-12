package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{AssessmentElement, AssessmentElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Assessment(
	name: String,
	desc: String = ""
) extends Motivation
	with AssessmentElement {

	case class AssessmentRelationships(
		override private[semod] implicit val tt: Assessment = Assessment.this
	) extends AssessmentElementRelationships[Assessment]

	val rel: AssessmentRelationships = AssessmentRelationships()

	_registerPrefix("MA")
}
