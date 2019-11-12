package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.{BusinessInterface, BusinessProcess, BusinessRole, BusinessService}
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_06_Serving extends App with ArchimateExample {

	val payInvoices = BusinessProcess("Pay Invoices")
	val customer = BusinessRole("Customer")
		.rel.assignedTo(payInvoices)
	val paymentService = BusinessService("Payment Service")
		.rel.serves(payInvoices)
	val paymentInterface = BusinessInterface("Payment Interface")
		.rel.serves(customer)
		.rel.assignedTo(paymentService)

	render(
		PlantUml.opt
			.title("Example 6. Serving (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993]]")
			.get,
		paymentService
	)

}
