package example.system

import example.Example
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait SystemExample extends Example {
	def render(options: PlantUml.Options, elements: Element*): Unit = super.render("system", options, elements: _*)
}
