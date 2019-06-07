package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessCollaboration, BusinessFunction, BusinessService}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008
	*/
case object Ex_16_DerivedFlowRelationships extends App with Example {

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


	render(
		PlantUml.opt
			.title("Example 16. Derived Flow Relationships (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008]]")
			.get,
		salesSvc
	)

}
