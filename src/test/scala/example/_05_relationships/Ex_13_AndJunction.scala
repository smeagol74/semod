package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessFunction, BusinessService}

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
			.title("Example 13. (And) Junction (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004")
			.get,
		invoicing
	))

}
