package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Physical

case class DistributionNetwork(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.distributionNetwork

	object rel extends StrategyCoreStructureBehaviorElementRelationships[DistributionNetwork] {
		private[archimate] implicit val tt: DistributionNetwork = DistributionNetwork.this
	}

}
