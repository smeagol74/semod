package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementProps, NodeElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class Node(
	name: String
) extends TechnologyLayer
	with NodeElement {

	case class NodeRelationships(
		override private[semod] implicit val tt: Node = Node.this
	) extends NodeElementRelationships[Node]

	val rel: NodeRelationships = NodeRelationships()

	case class NodeProps(
		override private[semod] implicit val tt: Node = Node.this
	) extends NodeElementProps[Node]

	val prop: NodeProps = NodeProps()

	_registerPrefix("TN")

}
