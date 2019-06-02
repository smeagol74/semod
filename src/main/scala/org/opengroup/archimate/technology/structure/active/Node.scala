package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Technology, TechnologyNodeElement, TechnologyNodeElementRelationships}

case class Node(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.technology.node

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Node]
		with TechnologyNodeElementRelationships[Node] {
		private[archimate] implicit val tt: Node = Node.this
	}

}
