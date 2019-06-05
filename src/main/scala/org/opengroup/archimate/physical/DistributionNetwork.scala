package org.opengroup.archimate.physical

import org.opengroup.archimate.meta.element.physical.{DistributionNetworkElement, DistributionNetworkElementRelationships}
import org.opengroup.archimate.meta.layer.Physical

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