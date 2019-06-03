package org.opengroup.archimate.physical

import org.opengroup.archimate.meta.element.physical.{DistributionNetworkElement, DistributionNetworkElementRelationships}
import org.opengroup.archimate.meta.layer.Physical

case class DistributionNetwork(
	name: String,
	desc: String = ""
) extends Physical
	with DistributionNetworkElement {

	object rel extends DistributionNetworkElementRelationships[DistributionNetwork] {
		private[archimate] implicit val tt: DistributionNetwork = DistributionNetwork.this
	}

}