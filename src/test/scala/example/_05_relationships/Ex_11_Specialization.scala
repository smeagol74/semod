package example._05_relationships

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.BusinessProcess

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946002
	*/
object Ex_11_Specialization extends App {

	val insurance = BusinessProcess("Take Out\nInsurance")
	val travel = BusinessProcess("Take Out\nTravel Insurance")
		.rel.specializationOf(insurance)
	val luggage = BusinessProcess("Take Out\nLuggage Insurance")
		.rel.specializationOf(insurance)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_11_Specialization")
			.title("Example 11. Specialization (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946002")
			.get,
		insurance
	))

}
