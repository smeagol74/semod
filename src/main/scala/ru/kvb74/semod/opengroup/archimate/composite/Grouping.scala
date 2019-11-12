package ru.kvb74.semod.opengroup.archimate.composite

import ru.kvb74.semod.opengroup.archimate.meta.element.composite.{GroupingElement, GroupingElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Composite

case class Grouping(
	name: String,
	desc: String = ""
) extends Composite
	with GroupingElement {

	case class GroupingRelationships(
		override private[semod] implicit val tt: Grouping = Grouping.this
	) extends GroupingElementRelationships[Grouping]

	val rel: GroupingRelationships = GroupingRelationships()

	_registerPrefix("CG")
}
