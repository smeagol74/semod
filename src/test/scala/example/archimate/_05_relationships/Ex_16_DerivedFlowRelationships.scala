package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.{BusinessCollaboration, BusinessFunction, BusinessService}
import ru.kvb74.semod.opengroup.archimate.composite.Location
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008
	*/
case object Ex_16_DerivedFlowRelationships extends App with ArchimateExample {

	val salesSvc = BusinessService("Sales Service")
	val developmentSvc = BusinessService("Development Service")
		.rel.flowsTo(salesSvc, "")
	val productDev = BusinessFunction("Product Development")
		.rel.realizes(developmentSvc)
	val sales = BusinessFunction("Sales")
		.rel.realizes(salesSvc)
	val rdDep = BusinessCollaboration("R&D Department")
		.rel.assignedTo(productDev)
  	.rel.associatedWith(sales, "derived flowsTo")
	val salesDep = BusinessCollaboration("Sales Department")
		.rel.assignedTo(sales)
	val londonOffice = Location("London Office")
  	.rel.aggregates(salesDep)
	val parisOffice = Location("Paris Office")
  		.rel.aggregates(rdDep)
  		.rel.associatedWith(londonOffice, "derived flowsTo")

	render(
		PlantUml.opt
			.title("Example 16. Derived Flow Relationships (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008]]")
			.get,
		salesSvc
	)

}
