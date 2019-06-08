package ru.kvb74.semod.opengroup.archimate

import java.util.ResourceBundle

object Resource {

	private var _bundle = ResourceBundle.getBundle("archimate/opengroup")

	def use(bundle: String): Unit = {
		_bundle = ResourceBundle.getBundle(s"archimate/$bundle")
	}

	def b: ResourceBundle = _bundle
}
