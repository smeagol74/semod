package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.{BusinessCollaboration, BusinessFunction}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008
	*/
case object Ex_17_DerivedTriggeringRelationships extends App with ArchimateExample {

	val shipping = BusinessFunction("Shipping")
	val billing = BusinessFunction("Billing & Payment")
		.rel.triggers(shipping)
	val selling = BusinessFunction("Selling")
		.rel.triggers(billing)
		.rel.associatedWith(shipping, "derived triggers")
	val shippingDep = BusinessCollaboration("Shipping Department")
		.rel.assignedTo(shipping)
	val financialDep = BusinessCollaboration("Financial Department")
		.rel.assignedTo(billing)
		.rel.associatedWith(shippingDep, "derived triggers")
	val salesDep = BusinessCollaboration("Sales Department")
		.rel.assignedTo(selling)
		.rel.associatedWith(financialDep, "derived triggers")

	render(
		PlantUml.opt
			.title("Example 17. Derived Triggering Relationships (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008]]")
			.get,
		billing
	)

}
