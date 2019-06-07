package example._05_relationships

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.{BusinessInterface, BusinessProcess, BusinessRole, BusinessService}

object Ex_06_Serving extends App {

	val payInvoices = BusinessProcess("Pay Invoices")
	val customer = BusinessRole("Customer")
		.rel.assignedTo(payInvoices)
	val paymentService = BusinessService("Payment Service")
		.rel.serves(payInvoices)
	val paymentInterface = BusinessInterface("Payment Interface")
		.rel.serves(customer)
		.rel.assignedTo(paymentService)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_06_Serving")
			.title("Example 6. Serving (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993")
			.get,
		paymentService
	))

}
