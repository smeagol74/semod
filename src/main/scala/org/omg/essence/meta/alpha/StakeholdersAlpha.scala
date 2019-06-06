package org.omg.essence.meta.alpha

import org.omg.essence.meta.area.Customer

trait StakeholdersAlpha
	extends Customer
		with Alpha

object StakeholdersState extends Enumeration {
	val RECOGNIZED,
	REPRESENTED,
	INVOLVED,
	IN_AGREEMENT,
	SATISFIED_FOR_DEPLOYMENT,
	SATISFIED_IN_USE = Value
}