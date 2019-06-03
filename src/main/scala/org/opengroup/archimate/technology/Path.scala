package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{PathElement, PathElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class Path(
	name: String,
	desc: String = ""
) extends Technology
	with PathElement {

	object rel extends PathElementRelationships[Path] {
		private[archimate] implicit val tt: Path = Path.this
	}

}
