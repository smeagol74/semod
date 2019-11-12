package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{GapElement, GapElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Implementation

case class Gap(
	name: String,
	desc: String = ""
) extends Implementation
	with GapElement {

	case class GapRelationships(
		override private[semod] implicit val tt: Gap = Gap.this
	) extends GapElementRelationships[Gap]

	val rel: GapRelationships = GapRelationships()

	_registerPrefix("IG")
}
