package ru.kvb74.semod.meta

case class Group(
	name: String
) extends AggregationElement
	with GroupElement {

	case class GroupRelationships(
		override private[semod] implicit val tt: Group = Group.this
	) extends GroupElementRelationships[Group]

	val rel: GroupRelationships = GroupRelationships()

	case class GroupProps(
		override private[semod] implicit val tt: Group = Group.this
	) extends GroupElementProps[Group]

	val prop: GroupProps = GroupProps()

	_registerPrefix("G")
}
