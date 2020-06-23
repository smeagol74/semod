package docs.ru.archimate

import docs.ru.Example
import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.{DB, Report}

trait ArchimateExample extends Example {
	def render(options: PlantUml.Options): Unit = {
		val els = DB.query.all.get
		super.render("archimate", options, Report(els))
	}
}
