package example

import ru.kvb74.semod.Report
import ru.kvb74.semod.meta.Element
import ru.kvb74.semod.plantuml.PlantUml

trait Example {

	def render(prefix: String, options: PlantUml.Options, report: Report): Unit = {
		val name = options.name.getOrElse(this.asInstanceOf[Product].productPrefix)

		PlantUml.render(
			PlantUml.opt
				.file(s"./src/test/puml/$prefix/$name.svg")
				.name(name)
				.title(options.title)
				.header(options.header)
				.footer(options.footer)
  			.showHints(options.showHints)
				.get,
			report
		)

		PlantUml.render(
			PlantUml.opt
				.file(s"./src/test/puml/$prefix/$name.puml")
				.name(name)
				.title(options.title)
				.header(options.header)
				.footer(options.footer)
				.showHints(options.showHints)
				.get,
			report
		)

		print(PlantUml.render(
			PlantUml.opt
				.file(None)
				.name(name)
				.title(options.title)
				.header(options.header)
				.footer(options.footer)
				.showHints(options.showHints)
				.get,
			report
		))
	}
}
