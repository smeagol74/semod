package ru.kvb74.semod.opengroup.archimate.technology

import ru.kvb74.semod.opengroup.archimate.meta.element.technology.{PathElement, PathElementProps, PathElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.TechnologyLayer

case class Path(
	name: String
) extends TechnologyLayer
	with PathElement {

	case class PathRelationships(
		override private[semod] implicit val tt: Path = Path.this
	) extends PathElementRelationships[Path]

	val rel: PathRelationships = PathRelationships()

	case class PathProps(
		override private[semod] implicit val tt: Path = Path.this
	) extends PathElementProps[Path]

	val prop: PathProps = PathProps()

	_registerPrefix("TPa")
}
