package docs.ru.system

import docs.ru.Example
import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.{DB, Report}

trait SystemExample extends Example {
	def render(options: PlantUml.Options): Unit = {
		val els = DB.query.all.get
		super.render("system", options, Report(els))
	}
}
