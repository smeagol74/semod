package org.opengroup.archimate.physical.structure.passive

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}
import org.opengroup.archimate.layer.Physical

case class Material(
	name: String,
	desc: String = ""
) extends Physical
	with PassiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.material

	object rel extends StrategyCoreStructureBehaviorElementRelationships[Material] {
		private[archimate] implicit val tt: Material = Material.this
	}

}
