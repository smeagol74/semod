package example.archimate

import example.Example
import ru.kvb74.semod.Report
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait ArchimateExample extends Example {
	def render(options: PlantUml.Options, elements: Element*): Unit = super.render("archimate", options, Report.withDependencies(elements: _*))
}
