package docs.ru.ontology

import docs.ru.Example
import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.{DB, Report}

trait OntologyExample extends Example {
	def render(options: PlantUml.Options): Unit = {
		val els = DB.query.all.get
		super.render("ontology", options, Report(els))
	}
}
