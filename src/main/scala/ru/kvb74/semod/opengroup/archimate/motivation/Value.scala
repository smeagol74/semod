package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{ValueElement, ValueElementProps, ValueElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Value(
	name: String
) extends MotivationLayer
	with ValueElement {

	case class ValueRelationships(
		override private[semod] implicit val tt: Value = Value.this
	) extends ValueElementRelationships[Value]

	val rel: ValueRelationships = ValueRelationships()

	case class ValueProps(
		override private[semod] implicit val tt: Value = Value.this
	) extends ValueElementProps[Value]

	val prop: ValueProps = ValueProps()

	_registerPrefix("MV")
}
