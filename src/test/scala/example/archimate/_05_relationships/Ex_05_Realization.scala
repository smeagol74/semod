package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.opengroup.archimate.business.{BusinessFunction, BusinessObject, BusinessService, Representation}
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_05_Realization extends App with ArchimateExample {

	val billingData = BusinessObject("Billing Data")

	val billingService = BusinessService("Billing Service")
		.rel.accesses(billingData, AccessMode.WRITE)

	val transactionProcessing = BusinessFunction("Transaction Processing")
		.rel.realizes(billingService)

	val paperInvoice = Representation("Paper Invoice")
		.rel.realizes(billingData)

	render(
		PlantUml.opt
			.title("Example 5. Realization (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993]]")
			.get,
		billingService
	)

}
