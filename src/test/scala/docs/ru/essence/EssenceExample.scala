package docs.ru.essence

import docs.ru.Example
import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.{DB, Report}

trait EssenceExample extends Example {
	def render(options: PlantUml.Options): Unit = {
		val els = DB.query.all.get
		super.render("essence", options, Report(els))
	}
}
