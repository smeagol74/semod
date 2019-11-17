package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemOurElement, SystemOurElementProps, SystemOurElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemOur(
	name: String
) extends SystemLayer
	with SystemOurElement {

	case class SystemOurRelationships(
		override private[semod] implicit val tt: SystemOur = SystemOur.this
	) extends SystemOurElementRelationships[SystemOur]

	val rel: SystemOurRelationships = SystemOurRelationships()

	case class SystemOurProps(
		override private[semod] implicit val tt: SystemOur = SystemOur.this
	) extends SystemOurElementProps[SystemOur]

	val prop: SystemOurProps = SystemOurProps()

	_registerPrefix("SOur")
}
