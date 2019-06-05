package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{CommunicationNetworkElement, CommunicationNetworkElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class CommunicationNetwork(
	name: String,
	desc: String = ""
) extends Technology
	with CommunicationNetworkElement {

	case class CommunicationNetworkRelationships(
		override private[archimate] implicit val tt: CommunicationNetwork = CommunicationNetwork.this
	) extends CommunicationNetworkElementRelationships[CommunicationNetwork]

	val rel: CommunicationNetworkRelationships = CommunicationNetworkRelationships()

}