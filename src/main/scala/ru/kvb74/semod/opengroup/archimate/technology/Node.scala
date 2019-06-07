package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class Node(
	name: String,
	desc: String = ""
) extends Technology
	with NodeElement {

	case class NodeRelationships(
		override private[archimate] implicit val tt: Node = Node.this
	) extends NodeElementRelationships[Node]

	val rel: NodeRelationships = NodeRelationships()

}
