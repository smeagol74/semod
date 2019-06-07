package example._05_relationships

import example._05_relationships.Ex_04_Assignment.paymentService
import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessFunction, BusinessObject, BusinessService, Representation}
import org.opengroup.archimate.relationship.dependency.AccessMode

object Ex_05_Realization extends App {

	val billingData = BusinessObject("Billing Data")

	val billingService = BusinessService("Billing Service")
		.rel.accesses(billingData, AccessMode.WRITE)

	val transactionProcessing = BusinessFunction("Transaction Processing")
		.rel.realizes(billingService)

	val paperInvoice = Representation("Paper Invoice")
		.rel.realizes(billingData)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_05_Realization")
			.title("Example 5. Realization (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993")
			.get,
		billingService
	))

}
