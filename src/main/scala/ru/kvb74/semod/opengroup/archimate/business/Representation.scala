package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{RepresentationElement, RepresentationElementProps, RepresentationElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class Representation(
	name: String
) extends BusinessLayer
	with RepresentationElement {

	case class RepresentationRelationships(
		override private[semod] implicit val tt: Representation = Representation.this
	) extends RepresentationElementRelationships[Representation]

	val rel: RepresentationRelationships = RepresentationRelationships()

	case class RepresentationProps(
		override private[semod] implicit val tt: Representation = Representation.this
	) extends RepresentationElementProps[Representation]

	val prop: RepresentationProps = RepresentationProps()

	_registerPrefix("BRep")
}
