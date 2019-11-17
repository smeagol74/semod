package example.features

import example.Example
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait FeaturesExample extends Example {
	def render(options: PlantUml.Options, elements: Element*): Unit = super.render("features", options, elements: _*)
}
