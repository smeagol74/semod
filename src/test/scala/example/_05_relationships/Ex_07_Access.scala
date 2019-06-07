package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessEvent, BusinessObject, BusinessProcess}
import org.opengroup.archimate.relationship.dependency.AccessMode

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945996
	*/
object Ex_07_Access extends App {

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

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_07_Access")
			.title("Example 7. Access (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945996")
			.get,
		invoice
	))

}
