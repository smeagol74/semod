package example.ontology

import example.Example
import ru.kvb74.semod.{DB, Report}
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait OntologyExample extends Example {
	def render(options: PlantUml.Options, elements: Element*): Unit = {
		val els = DB.query.forElements(elements: _*)
  		.relationsRecursive
  		.get
		super.render("ontology", options, Report(els))
	}
}
