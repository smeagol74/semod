package example._05_relationships

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.{BusinessFunction, BusinessService}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004
	*/
object Ex_13_AndJunction extends App {

	val sales = BusinessFunction("Sales")
	val finance = BusinessFunction("Finance")

	val invoicing = BusinessService("Invoicing")
		.rel.junction.and(sales, finance).realizesThis

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_13_AndJunction")
			.title("Example 13. (And) Junction (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004")
			.get,
		invoicing
	))

}
