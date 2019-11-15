package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{PathElement, PathElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class Path(
	name: String,
	desc: String = ""
) extends TechnologyLayer
	with PathElement {

	case class PathRelationships(
		override private[semod] implicit val tt: Path = Path.this
	) extends PathElementRelationships[Path]

	val rel: PathRelationships = PathRelationships()

	_registerPrefix("TPa")
}
