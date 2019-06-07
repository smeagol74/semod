package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{PathElement, PathElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Technology

case class Path(
	name: String,
	desc: String = ""
) extends Technology
	with PathElement {

	case class PathRelationships(
		override private[archimate] implicit val tt: Path = Path.this
	) extends PathElementRelationships[Path]

	val rel: PathRelationships = PathRelationships()

}
