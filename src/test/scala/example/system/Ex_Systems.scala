package example.system

import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.system.system.{Placeholder, SystemSupraOfInterest, SystemEnabling, SystemOfInterest, SystemOther, SystemOur, SystemRole}

case object Ex_Systems extends App with SystemExample {

	val top = SystemOther("Owning System")
	val ssoi = SystemSupraOfInterest("SupraSystem of Interest")
	val placeholder = Placeholder("System Type")
	val role = SystemRole("Performer")
	val soi = SystemOfInterest("System of Interest")
	val our = SystemOur("Our SubSystem")
	val concurrent = SystemOther("Concurrent System")
	val support = SystemEnabling("Our Business System")

	top
		.rel.composedOf(ssoi)
	ssoi
		.rel.composedOf(placeholder)
		.rel.composedOf(role)
	soi
		.rel.realizes(placeholder)
		.rel.composedOf(our)
	concurrent
		.rel.realizes(placeholder)
	support
		.rel.composedOf(soi)

	render(
		PlantUml.opt
			.title("Example. Systems")
			.get,
		top
	)

}
