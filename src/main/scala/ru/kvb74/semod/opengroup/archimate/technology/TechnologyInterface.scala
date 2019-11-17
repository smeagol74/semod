package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{TechnologyInterfaceElement, TechnologyInterfaceElementProps, TechnologyInterfaceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class TechnologyInterface(
	name: String
) extends TechnologyLayer
	with TechnologyInterfaceElement {

	case class TechnologyInterfaceRelationships(
		override private[semod] implicit val tt: TechnologyInterface = TechnologyInterface.this
	) extends TechnologyInterfaceElementRelationships[TechnologyInterface]

	val rel: TechnologyInterfaceRelationships = TechnologyInterfaceRelationships()

	case class TechnologyInterfaceProps(
		override private[semod] implicit val tt: TechnologyInterface = TechnologyInterface.this
	) extends TechnologyInterfaceElementProps[TechnologyInterface]

	val prop: TechnologyInterfaceProps = TechnologyInterfaceProps()

	_registerPrefix("TIf")
}
