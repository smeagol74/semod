package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.opengroup.archimate.business.{BusinessEvent, BusinessObject, BusinessProcess}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945996
	*/
case object Ex_07_Access extends App with ArchimateExample {

	val invoiceSent = BusinessEvent("Invoice Sent")
	val invoice = BusinessObject("Invoice")
	val sendInvoice = BusinessProcess("Send Invoice")
		.rel.triggers(invoiceSent)
		.rel.accesses(invoice, AccessMode.READ)
	val createInvoice = BusinessProcess("Create Invoice")
		.rel.triggers(sendInvoice)
		.rel.accesses(invoice, AccessMode.WRITE)
	val invoiceRequest = BusinessEvent("Invoice Request")
		.rel.triggers(createInvoice)

	render(
		PlantUml.opt
			.title("Example 7. Access (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945996]]")
			.get,
		invoice
	)

}
