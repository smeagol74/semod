package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{CompetencyElement, CompetencyElementProps, CompetencyElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Competency(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with CompetencyElement {

	case class CompetencyRelationships(
		override private[semod] implicit val tt: Competency = Competency.this
	) extends CompetencyElementRelationships[Competency]

	val rel: CompetencyRelationships = CompetencyRelationships()

	case class CompetencyProps(
		override private[semod] implicit val tt: Competency = Competency.this
	) extends CompetencyElementProps[Competency]

	val prop: CompetencyProps = CompetencyProps()

	_registerPrefix("EC")

}

