package ru.kvb74.semod.opengroup.archimate.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.composite.{GroupingElement, GroupingElementProps, GroupingElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.CompositeLayer

case class Grouping(
	name: String
) extends CompositeLayer
	with GroupingElement {

	case class GroupingRelationships(
		override private[semod] implicit val tt: Grouping = Grouping.this
	) extends GroupingElementRelationships[Grouping]

	val rel: GroupingRelationships = GroupingRelationships()

	case class GroupingProps(
		override private[semod] implicit val tt: Grouping = Grouping.this
	) extends GroupingElementProps[Grouping]

	val prop: GroupingProps = GroupingProps()

	_registerPrefix("CG")
}
