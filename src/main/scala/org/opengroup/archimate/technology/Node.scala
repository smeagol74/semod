package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{NodeElement, NodeElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class Node(
	name: String,
	desc: String = ""
) extends Technology
	with NodeElement {

	object rel extends NodeElementRelationships[Node] {
		private[archimate] implicit val tt: Node = Node.this
	}

}
