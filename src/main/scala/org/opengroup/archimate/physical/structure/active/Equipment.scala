package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.{Physical, TechnologyInternalBehaviorElement, TechnologyNodeElement, TechnologyNodeElementRelationships}
import org.opengroup.archimate.physical.structure.passive.Material

case class Equipment(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with TechnologyNodeElement {
	val id: String = IdGenerator.physical.equipment

	object rel extends EquipmentRelationships[Equipment] {
		private[archimate] implicit val tt: Equipment = Equipment.this
	}

}

trait EquipmentRelationships[T <: Equipment]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
		with TechnologyNodeElementRelationships[T] {

	def isSpecializationOf(dst: TechnologyNodeElement): T = tt._rel.isSpecializationOf(dst)

	def assignedTo(dst: Material): T = tt._rel.assignedTo(dst)
}
