package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{ActivityElement, ActivityElementProps, ActivityElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Activity(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with ActivityElement {

	case class ActivityRelationships(
		override private[semod] implicit val tt: Activity = Activity.this
	) extends ActivityElementRelationships[Activity]

	val rel: ActivityRelationships = ActivityRelationships()

	case class ActivityProps(
		override private[semod] implicit val tt: Activity = Activity.this
	) extends ActivityElementProps[Activity]

	val prop: ActivityProps = ActivityProps()

	_registerPrefix("EAc")

}

