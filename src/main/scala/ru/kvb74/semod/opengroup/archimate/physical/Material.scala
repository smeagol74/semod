package ru.kvb74.semod.opengroup.archimate.physical

import ru.kvb74.semod.opengroup.archimate.meta.element.physical.{MaterialElement, MaterialElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Physical

case class Material(
	name: String,
	desc: String = ""
) extends Physical
	with MaterialElement {

	case class MaterialRelationships(
		override private[archimate] implicit val tt: Material = Material.this
	) extends MaterialElementRelationships[Material]

	val rel: MaterialRelationships = MaterialRelationships()

}