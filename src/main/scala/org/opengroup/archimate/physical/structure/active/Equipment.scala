package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.IdGenerator
import org.opengroup.archimate.element.{ActiveStructureElement, StrategyCoreStructureBehaviorElement}
import org.opengroup.archimate.layer.Physical

case class Equipment(
	name: String,
	desc: String = ""
) extends Physical
	with ActiveStructureElement
	with StrategyCoreStructureBehaviorElement {
	val id: String = IdGenerator.physical.equipment
}
