package org.opengroup.archimate.physical.structure.active

import org.opengroup.archimate.element.ActiveStructureElement
import org.opengroup.archimate.layer.Physical

case class DistributionNetwork(
	id: String = "",
	name: String = "",
	desc: String = ""
) extends Physical with ActiveStructureElement {

}
