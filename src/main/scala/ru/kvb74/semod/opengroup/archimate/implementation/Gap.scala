package ru.kvb74.semod.opengroup.archimate.implementation

import ru.kvb74.semod.opengroup.archimate.meta.element.implementation.{GapElement, GapElementProps, GapElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ImplementationLayer

case class Gap(
	name: String
) extends ImplementationLayer
	with GapElement {

	case class GapRelationships(
		override private[semod] implicit val tt: Gap = Gap.this
	) extends GapElementRelationships[Gap]

	val rel: GapRelationships = GapRelationships()

	case class GapProps(
		override private[semod] implicit val tt: Gap = Gap.this
	) extends GapElementProps[Gap]

	val prop: GapProps = GapProps()

	_registerPrefix("IG")
}
