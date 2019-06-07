package ru.kvb74.semod.omg.essence.core

import ru.kvb74.semod.omg.essence.meta.alpha.{Alpha, AlphaState}

object Stakeholders {
	object State extends Enumeration with AlphaState {
	}

	case class Model(
		state: State.Value
	) extends Alpha {

	}
}
