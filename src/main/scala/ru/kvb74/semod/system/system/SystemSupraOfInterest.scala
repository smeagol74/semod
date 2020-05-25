package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemSupraOfInterestElement, SystemSupraOfInterestElementProps, SystemSupraOfInterestElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemSupraOfInterest(
	name: String
) extends SystemLayer
	with SystemSupraOfInterestElement {

	case class SystemSupraOfInterestRelationships(
		override private[semod] implicit val tt: SystemSupraOfInterest = SystemSupraOfInterest.this
	) extends SystemSupraOfInterestElementRelationships[SystemSupraOfInterest]

	val rel: SystemSupraOfInterestRelationships = SystemSupraOfInterestRelationships()

	case class SystemSupraOfInterestProps(
		override private[semod] implicit val tt: SystemSupraOfInterest = SystemSupraOfInterest.this
	) extends SystemSupraOfInterestElementProps[SystemSupraOfInterest]

	val prop: SystemSupraOfInterestProps = SystemSupraOfInterestProps()

	_registerPrefix("SSOI")
}
