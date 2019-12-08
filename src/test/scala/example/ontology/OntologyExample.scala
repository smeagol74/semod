package example.ontology

import example.Example
import ru.kvb74.semod.Report
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait OntologyExample extends Example {
	def render(options: PlantUml.Options, elements: Element*): Unit = super.render("ontology", options, Report.withDependencies(elements: _*))
}
