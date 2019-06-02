package org.opengroup.archimate.physical.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Physical, TechnologyObjectElement, TechnologyObjectElementRelationships}
import org.opengroup.archimate.physical.structure.active.DistributionNetwork

case class Material(
	name: String,
	desc: String = ""
) extends Physical
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyObjectElement {
	val id: String = IdGenerator.physical.material

	object rel extends MaterialRelationships[Material] {
		private[archimate] implicit val tt: Material = Material.this
	}

}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946105
	*/
trait MaterialRelationships[T <: Material]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyObjectElementRelationships[T] {
	def isSpecializationOf(dst: TechnologyObjectElement): T = tt._rel.isSpecializationOf(dst)

	def associatedWith(dst: DistributionNetwork): T = tt._rel.associatedWith(dst)
}