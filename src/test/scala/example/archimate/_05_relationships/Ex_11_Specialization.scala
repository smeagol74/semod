package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.BusinessProcess
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946002
	*/
case object Ex_11_Specialization extends App with ArchimateExample {

	val insurance = BusinessProcess("Take Out\nInsurance")
	val travel = BusinessProcess("Take Out\nTravel Insurance")
		.rel.specializationOf(insurance)
	val luggage = BusinessProcess("Take Out\nLuggage Insurance")
		.rel.specializationOf(insurance)

	render(
		PlantUml.opt
			.title("Example 11. Specialization (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946002]]")
			.get,
		insurance
	)

}
