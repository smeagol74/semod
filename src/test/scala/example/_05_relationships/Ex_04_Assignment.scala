package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business._

object Ex_04_Assignment extends App {

	val paymentService = BusinessService("Payment Service")

	val paymentInterface = BusinessInterface("Payment Interface")
		.rel.assignedTo(paymentService)

	val transactionProcessing = BusinessFunction("Transaction Processing")
		.rel.realizes(paymentService)

	val finance = BusinessCollaboration("Finance")
		.rel.composedOf(paymentInterface)
		.rel.assignedTo(transactionProcessing)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_04_Assignment")
			.title("Example 4. Assignment (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945992")
			.get,
		paymentService
	))

}
