package example.features

import ru.kvb74.semod.DB
import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.system.system.{SystemOther, SystemOur}

case object Ex_Tags_Any extends App with FeaturesExample {

	val s1 = SystemOther("Main System")
		.prop.tags("visible", "main")
		.rel.composedOf(s11)
		.rel.composedOf(s12)
		.rel.composedOf(s13)

	lazy val s11 = SystemOther("Subsystem 1.1")
		.prop.tags("invisible", "sub")
		.rel.composedOf(
		SystemOther("Subsystem 1.1.1")
			.prop.tags("visible")
	)
		.rel.composedOf(
		SystemOther("Subsystem 1.1.2")
			.prop.tags("invisible")
	)

	lazy val s12 = SystemOther("Subsystem 1.2")
		.prop.tags("visible", "sub")
		.rel.composedOf(
		SystemOther("Subsystem 1.2.1")
			.prop.tags("visible")
	)
		.rel.composedOf(
		SystemOther("Subsystem 1.2.2")
			.prop.tags("invisible")
	)

	lazy val s13 = SystemOur("Subsystem 1.3")
		.prop.tags("visible", "sub")
		.rel.composedOf(
		SystemOther("Subsystem 1.3.1")
			.prop.tags("visible")
	)
		.rel.composedOf(
		SystemOther("Subsystem 1.3.2")
			.prop.tags("invisible")
	)


	render(
		PlantUml.opt
			.title("Example. Features: Tags Any")
			.get,
		DB.query.all
			.anyTags("visible", "sub")
			.get
	)

}
