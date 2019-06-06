package org.omg.essence.core

import org.omg.essence.meta.alpha.{Alpha, AlphaState}

object Stakeholders {
	object State extends Enumeration with AlphaState {
	}

	case class Model(
		state: State.Value
	) extends Alpha {

	}
}
