package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{ArtifactElement, ArtifactElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class Artifact(
	name: String,
	desc: String = ""
) extends Technology
	with ArtifactElement {

	case class ArtifactRelationships(
		override private[archimate] implicit val tt: Artifact = Artifact.this
	) extends ArtifactElementRelationships[Artifact]

	val rel: ArtifactRelationships = ArtifactRelationships()

}