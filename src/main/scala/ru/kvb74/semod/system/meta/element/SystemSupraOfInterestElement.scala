package ru.kvb74.semod.system.meta.element

import ru.kvb74.semod.meta.{ElementName, RR}

trait SystemSupraOfInterestElement
	extends SystemElement

case object SystemSupraOfInterestElement
	extends ElementName

trait SystemSupraOfInterestElementProps[T <: SystemSupraOfInterestElement]
	extends SystemElementProps[T]

trait SystemSupraOfInterestElementRelationships[T <: SystemSupraOfInterestElement]
	extends SystemElementRelationships[T] {

	def composedOf(dst: PlaceholderElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: SystemOtherElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: SystemOurElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: SystemRoleElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: SystemEnablingElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: SystemOfInterestElement): T = tt._rel.composedOf(dst)

	def realizes(dst: PlaceholderElement): T = tt._rel.realizes(dst)

	_register(SystemSupraOfInterestElement,
		RR.composedOf(PlaceholderElement),
		RR.composedOf(SystemOtherElement),
		RR.composedOf(SystemOurElement),
		RR.composedOf(SystemRoleElement),
		RR.composedOf(SystemEnablingElement),
		RR.composedOf(SystemOfInterestElement),
		RR.realizes(PlaceholderElement),
	)
}
