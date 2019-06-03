package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{ArtifactElement, ArtifactElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class Artifact(
	name: String,
	desc: String = ""
) extends Technology
	with ArtifactElement {

	object rel extends ArtifactElementRelationships[Artifact] {
		private[archimate] implicit val tt: Artifact = Artifact.this
	}

}
