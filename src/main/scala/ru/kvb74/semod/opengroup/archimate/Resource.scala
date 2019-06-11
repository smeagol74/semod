package ru.kvb74.semod.opengroup.archimate

import java.util.ResourceBundle

object Resource {
	def bundle(bundle: String): ResourceBundle = ResourceBundle.getBundle(s"archimate/$bundle")
}
