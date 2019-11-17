package example.features

import ru.kvb74.semod.opengroup.archimate.application.{ApplicationInterface, ApplicationProcess}
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_Links extends App with FeaturesExample {
	val intf = ApplicationInterface("Some interface")
  	.prop.link("https://google.com")
  	.prop.tooltip("Google main page")
  	.prop.desc(
		"""
			|Here some description also
		""".stripMargin)

	val proc1 = ApplicationProcess("Some Process")
		.prop.link("https://github.com")
		.prop.desc(
		"""
			|Here is some rather big description of the element.
			|
			|It is possible to use markdown language to describe elements
		""".stripMargin)
  	.rel.associatedWith(intf)

	val proc2 = ApplicationProcess("Another Process")
		.prop.tooltip("process")
  	.rel.associatedWith(intf)

	render(
		PlantUml.opt
			.title("Example. Features: Links")
			.get,
		intf,
		proc1,
		proc2
	)

}
