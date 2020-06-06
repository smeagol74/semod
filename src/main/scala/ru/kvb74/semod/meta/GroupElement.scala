package ru.kvb74.semod.meta

trait GroupElement
	extends Element

case object GroupElement
	extends ElementName

trait GroupElementProps[T <: GroupElement]
	extends ElementProps[T]

trait GroupElementRelationships[T <: GroupElement]
	extends ElementRelationships[T] {

	def aggregates(dst: Element): T = tt._rel.aggregates(dst)

	_register(GroupElement,
		RR.aggregates(Element),
	)

}
