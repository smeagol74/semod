package org.opengroup.archimate.technology.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, Element, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Technology

case class CommunicationNetwork(
	name: String,
	desc: String = ""
) extends Technology
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.technology.communicationNetwork

	object rel extends CommunicationNetworkRelationships[CommunicationNetwork] {
		private[archimate] implicit val tt: CommunicationNetwork = CommunicationNetwork.this
	}

}

trait CommunicationNetworkRelationships[T <: Element]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: Path): T = tt._rel.realizes(dst)

	def associatedWith(dst: Device): T = tt._rel.associatedWith(dst)

	def aggregates(dst: Device): T = tt._rel.aggregates(dst)

	def associatedWith(dst: SystemSoftware): T = tt._rel.associatedWith(dst)

	def aggregates(dst: SystemSoftware): T = tt._rel.aggregates(dst)
}
