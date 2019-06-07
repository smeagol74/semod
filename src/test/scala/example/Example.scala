package example

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.meta.element.Element
import ru.kvb74.semod.plantuml.PlantUml

trait Example {

	def render(options: PlantUml.Options, elements: Element*): Unit = {
		val report = Report.withDependencies(elements: _*)

		val name = options.name.getOrElse(this.asInstanceOf[Product].productPrefix)

		PlantUml.render(
			PlantUml.opt
				.file(s"./src/test/puml/$name.svg")
				.name(name)
				.title(options.title)
				.header(options.header)
				.footer(options.footer)
				.get,
			report
		)

		PlantUml.render(
			PlantUml.opt
				.file(s"./src/test/puml/$name.puml")
				.name(name)
				.title(options.title)
				.header(options.header)
				.footer(options.footer)
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
				.get,
			report
		))
	}
}
