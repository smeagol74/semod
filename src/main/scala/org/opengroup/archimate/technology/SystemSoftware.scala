package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{SystemSoftwareElement, SystemSoftwareElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class SystemSoftware(
	name: String,
	desc: String = ""
) extends Technology
	with SystemSoftwareElement {

	object rel extends SystemSoftwareElementRelationships[SystemSoftware] {
		private[archimate] implicit val tt: SystemSoftware = SystemSoftware.this
	}

}
