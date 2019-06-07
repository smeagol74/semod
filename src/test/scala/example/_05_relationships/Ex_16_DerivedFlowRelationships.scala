package example._05_relationships

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.{BusinessCollaboration, BusinessFunction, BusinessService}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008
	*/
object Ex_16_DerivedFlowRelationships extends App {

	val salesSvc = BusinessService("Sales Service")
	val developmentSvc = BusinessService("Development Service")
		.rel.flowsTo(salesSvc, "")
	val productDev = BusinessFunction("Product Development")
		.rel.realizes(developmentSvc)
	val rdDep = BusinessCollaboration("R&D Department")
		.rel.assignedTo(productDev)
	val sales = BusinessFunction("Sales")
		.rel.realizes(salesSvc)
	val salesDep = BusinessCollaboration("Sales Department")
		.rel.assignedTo(sales)
	//TODO complete Location element and flow relationships


	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_16_DerivedFlowRelationships")
			.title("Example 16. Derived Flow Relationships (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008")
			.get,
		salesSvc
	))

}
