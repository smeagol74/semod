package ru.kvb74.semod.opengroup.archimate.physical

import ru.kvb74.semod.opengroup.archimate.meta.element.physical.{DistributionNetworkElement, DistributionNetworkElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Physical

case class DistributionNetwork(
	name: String,
	desc: String = ""
) extends Physical
	with DistributionNetworkElement {

	case class DistributionNetworkRelationships(
		private[archimate] implicit val tt: DistributionNetwork = DistributionNetwork.this
	) extends DistributionNetworkElementRelationships[DistributionNetwork]

	val rel: DistributionNetworkRelationships = DistributionNetworkRelationships()

}