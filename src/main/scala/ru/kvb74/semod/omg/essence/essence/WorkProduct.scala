package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{WorkProductElement, WorkProductElementProps, WorkProductElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class WorkProduct(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with WorkProductElement {

	case class WorkProductRelationships(
		override private[semod] implicit val tt: WorkProduct = WorkProduct.this
	) extends WorkProductElementRelationships[WorkProduct]

	val rel: WorkProductRelationships = WorkProductRelationships()

	case class WorkProductProps(
		override private[semod] implicit val tt: WorkProduct = WorkProduct.this
	) extends WorkProductElementProps[WorkProduct]

	val prop: WorkProductProps = WorkProductProps()

	_registerPrefix("EWP")

}

