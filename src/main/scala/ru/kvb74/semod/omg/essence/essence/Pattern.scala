package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{PatternElement, PatternElementProps, PatternElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Pattern(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with PatternElement {

	case class PatternRelationships(
		override private[semod] implicit val tt: Pattern = Pattern.this
	) extends PatternElementRelationships[Pattern]

	val rel: PatternRelationships = PatternRelationships()

	case class PatternProps(
		override private[semod] implicit val tt: Pattern = Pattern.this
	) extends PatternElementProps[Pattern]

	val prop: PatternProps = PatternProps()

	_registerPrefix("EPa")

}

