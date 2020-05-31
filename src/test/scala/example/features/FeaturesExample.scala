package example.features

import example.Example
import ru.kvb74.semod.Report
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait FeaturesExample extends Example {
	def render(options: PlantUml.Options, elements: Set[Element]): Unit = super.render("features", options, Report(elements))
	def render(options: PlantUml.Options, elements: Element*): Unit = render(options, elements.toSet)
}
