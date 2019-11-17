package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessRoleElement, BusinessRoleElementProps, BusinessRoleElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessRole(
	name: String
) extends BusinessLayer
	with BusinessRoleElement {

	case class BusinessRoleRelationships(
		override private[semod] implicit val tt: BusinessRole = BusinessRole.this
	) extends BusinessRoleElementRelationships[BusinessRole]

	val rel: BusinessRoleRelationships = BusinessRoleRelationships()

	case class BusinessRoleProps(
		override private[semod] implicit val tt: BusinessRole = BusinessRole.this
	) extends BusinessRoleElementProps[BusinessRole]

	val prop: BusinessRoleProps = BusinessRoleProps()

	_registerPrefix("BR")
}
