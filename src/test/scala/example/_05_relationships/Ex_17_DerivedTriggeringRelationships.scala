package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessCollaboration, BusinessFunction, BusinessService}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008
	*/
object Ex_17_DerivedTriggeringRelationships extends App {

	val shipping = BusinessFunction("Shipping")
	val billing = BusinessFunction("Billing & Payment")
		.rel.triggers(shipping)
	val selling = BusinessFunction("Selling")
		.rel.triggers(billing)
		.rel.triggers(shipping) // TODO This one should be derived
	val salesDep = BusinessCollaboration("Sales Department")
		.rel.assignedTo(selling)
	//    .rel.triggers(financialDep) // TODO This one should be derived
	val financialDep = BusinessCollaboration("Financial Department")
		.rel.assignedTo(billing)
	// .rel.triggers(shippingDep) // TODO This one should be derived
	val shippingDep = BusinessCollaboration("Shipping Department")
		.rel.assignedTo(shipping)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_17_DerivedTriggeringRelationships")
			.title("Example 17. Derived Triggering Relationships (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946008")
			.get,
		billing
	))

}
