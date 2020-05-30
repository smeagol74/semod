package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{ActivitySpaceElement, ActivitySpaceElementProps, ActivitySpaceElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class ActivitySpace(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with ActivitySpaceElement {

	case class ActivitySpaceRelationships(
		override private[semod] implicit val tt: ActivitySpace = ActivitySpace.this
	) extends ActivitySpaceElementRelationships[ActivitySpace]

	val rel: ActivitySpaceRelationships = ActivitySpaceRelationships()

	case class ActivitySpaceProps(
		override private[semod] implicit val tt: ActivitySpace = ActivitySpace.this
	) extends ActivitySpaceElementProps[ActivitySpace]

	val prop: ActivitySpaceProps = ActivitySpaceProps()

	_registerPrefix("EAcS")

}

