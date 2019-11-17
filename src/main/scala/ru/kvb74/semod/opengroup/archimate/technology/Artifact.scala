package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{ArtifactElement, ArtifactElementProps, ArtifactElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class Artifact(
	name: String
) extends TechnologyLayer
	with ArtifactElement {

	case class ArtifactRelationships(
		override private[semod] implicit val tt: Artifact = Artifact.this
	) extends ArtifactElementRelationships[Artifact]

	val rel: ArtifactRelationships = ArtifactRelationships()

	case class ArtifactProps(
		override private[semod] implicit val tt: Artifact = Artifact.this
	) extends ArtifactElementProps[Artifact]

	val prop: ArtifactProps = ArtifactProps()

	_registerPrefix("TA")
}
