package ru.kvb74.semod.opengroup.archimate.physical

import ru.kvb74.semod.opengroup.archimate.meta.element.physical.{MaterialElement, MaterialElementProps, MaterialElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.PhysicalLayer

case class Material(
	name: String
) extends PhysicalLayer
	with MaterialElement {

	case class MaterialRelationships(
		override private[semod] implicit val tt: Material = Material.this
	) extends MaterialElementRelationships[Material]

	val rel: MaterialRelationships = MaterialRelationships()

	case class MaterialProps(
		override private[semod] implicit val tt: Material = Material.this
	) extends MaterialElementProps[Material]

	val prop: MaterialProps = MaterialProps()

	_registerPrefix("PM")
}