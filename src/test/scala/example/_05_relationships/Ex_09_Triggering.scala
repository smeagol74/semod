package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessEvent, BusinessProcess}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945999
	*/
object Ex_09_Triggering extends App {

	val sent = BusinessEvent("Invoice Sent")
	val send = BusinessProcess("Send Invoice")
		.rel.triggers(sent)
	val create = BusinessProcess("Create Invoice")
		.rel.triggers(send)
	val requested = BusinessEvent("Invoice Requested")
		.rel.triggers(create)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_09_Triggering")
			.title("Example 9. Triggering (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945999")
			.get,
		requested
	))

}
