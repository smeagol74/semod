package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessRoleElement, BusinessRoleElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessRole(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessRoleElement {

	case class BusinessRoleRelationships(
		override private[semod] implicit val tt: BusinessRole = BusinessRole.this
	) extends BusinessRoleElementRelationships[BusinessRole]

	val rel: BusinessRoleRelationships = BusinessRoleRelationships()

	_registerPrefix("BR")
}
