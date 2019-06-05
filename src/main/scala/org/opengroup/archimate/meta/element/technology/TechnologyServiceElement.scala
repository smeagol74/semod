package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyServiceElement
	extends BehaviorElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyServiceElement
	extends ElementName

trait TechnologyServiceElementRelationships[T <: TechnologyServiceElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def triggers(dst: TechnologyServiceElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyServiceElement): T = tt._rel.flowsTo(dst)

	def triggers(dst: TechnologyEventElement): T = tt._rel.triggers(dst)

	def flowsTo(dst: TechnologyEventElement): T = tt._rel.flowsTo(dst)

	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)

	def accesses(dst: ArtifactElement): T = tt._rel.accesses(dst)

	def serves(dst: TechnologyInternalBehaviorElement): T = tt._rel.serves(dst)

	def serves(dst: NodeElement): T = tt._rel.serves(dst)

	def serves(dst: SystemSoftwareElement): T = tt._rel.serves(dst)

	def serves(dst: DeviceElement): T = tt._rel.serves(dst)

	def serves(dst: TechnologyCollaborationElement): T = tt._rel.serves(dst)

	_register(TechnologyServiceElement,
		JR.triggers(TechnologyServiceElement),
		JR.flowsTo(TechnologyServiceElement),
		JR.triggers(TechnologyEventElement),
		JR.flowsTo(TechnologyEventElement),
		JR.accesses(TechnologyObjectElement),
		JR.accesses(ArtifactElement),
		JR.serves(TechnologyInternalBehaviorElement),
		JR.serves(NodeElement),
		JR.serves(SystemSoftwareElement),
		JR.serves(DeviceElement),
		JR.serves(TechnologyCollaborationElement),
	)
}