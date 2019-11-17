package ru.kvb74.semod.system.system

import ru.kvb74.semod.system.meta.element.{SystemOfInterestElement, SystemOfInterestElementProps, SystemOfInterestElementRelationships}
import ru.kvb74.semod.system.meta.layer.SystemLayer

case class SystemOfInterest(
	name: String
) extends SystemLayer
	with SystemOfInterestElement {

	case class SystemOfInterestRelationships(
		override private[semod] implicit val tt: SystemOfInterest = SystemOfInterest.this
	) extends SystemOfInterestElementRelationships[SystemOfInterest]

	val rel: SystemOfInterestRelationships = SystemOfInterestRelationships()

	case class SystemOfInterestProps(
		override private[semod] implicit val tt: SystemOfInterest = SystemOfInterest.this
	) extends SystemOfInterestElementProps[SystemOfInterest]

	val prop: SystemOfInterestProps = SystemOfInterestProps()

	_registerPrefix("SOI")
}
