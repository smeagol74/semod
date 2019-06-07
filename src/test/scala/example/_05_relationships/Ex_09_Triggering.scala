package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessEvent, BusinessProcess}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945999
	*/
case object Ex_09_Triggering extends App with Example {

	val sent = BusinessEvent("Invoice Sent")
	val send = BusinessProcess("Send Invoice")
		.rel.triggers(sent)
	val create = BusinessProcess("Create Invoice")
		.rel.triggers(send)
	val requested = BusinessEvent("Invoice Requested")
		.rel.triggers(create)

	render(
		PlantUml.opt
			.title("Example 9. Triggering (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945999]]")
			.get,
		requested
	)

}
