package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Physical
import org.opengroup.archimate.physical.structure.passive.Material
import org.opengroup.archimate.technology.structure.active.Path

case class DistributionNetwork(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.distributionNetwork

	object rel extends DistributionNetworkRelationships[DistributionNetwork] {
		private[archimate] implicit val tt: DistributionNetwork = DistributionNetwork.this
	}

}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946104
	*/
trait DistributionNetworkRelationships[T <: DistributionNetwork]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def realizes(dst: Path): T = tt._rel.realizes(dst)

	def associatedWith(dst: Facility): T = tt._rel.associatedWith(dst)

	def aggregates(dst: Facility): T = tt._rel.aggregates(dst)

	def aggregates(dst: Equipment): T = tt._rel.aggregates(dst)

	def associatedWith(dst: Material): T = tt._rel.associatedWith(dst)
}
