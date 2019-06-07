package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business._
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_04_Assignment extends App with Example {

	val paymentService = BusinessService("Payment Service")

	val paymentInterface = BusinessInterface("Payment Interface")
		.rel.assignedTo(paymentService)

	val transactionProcessing = BusinessFunction("Transaction Processing")
		.rel.realizes(paymentService)

	val finance = BusinessCollaboration("Finance")
		.rel.composedOf(paymentInterface)
		.rel.assignedTo(transactionProcessing)

	render(
		PlantUml.opt
			.title("Example 4. Assignment (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945992]]")
			.get,
		paymentService
	)

}
