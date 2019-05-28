package org.opengroup.archimate.business.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ElementRelationships, PassiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.{Business, BusinessPassiveStructureElement}

case class Representation(
	name: String,
	desc: String = ""
) extends Business
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement
	with BusinessPassiveStructureElement {
	val id: String = IdGenerator.business.representation

	object rel extends ElementRelationships[Representation] {
		private[archimate] implicit val tt: Representation = Representation.this

		def realizes(dst: BusinessObject): Representation = tt._rel.realizes(dst)
		def realizes(dst: Contract): Representation = tt._rel.realizes(dst)
	}

}
