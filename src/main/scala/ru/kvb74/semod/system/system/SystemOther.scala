package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemOtherElement, SystemOtherElementProps, SystemOtherElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer


case class SystemOther(
	name: String
) extends SystemLayer
	with SystemOtherElement {

	case class SystemOtherRelationships(
		override private[semod] implicit val tt: SystemOther = SystemOther.this
	) extends SystemOtherElementRelationships[SystemOther]

	val rel: SystemOtherRelationships = SystemOtherRelationships()

	case class SystemOtherProps(
		override private[semod] implicit val tt: SystemOther = SystemOther.this
	) extends SystemOtherElementProps[SystemOther]

	val prop: SystemOtherProps = SystemOtherProps()

	_registerPrefix("SOther")
}
