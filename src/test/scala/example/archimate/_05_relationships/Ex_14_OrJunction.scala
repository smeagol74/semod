package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.{BusinessEvent, BusinessProcess}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004
	*/
case object Ex_14_OrJunction extends App with ArchimateExample {

	val accept = BusinessProcess("Accept Request")
	val reject = BusinessProcess("Reject Request")

	val assess = BusinessProcess("Assess Request")
		.rel.junction.triggers.or(accept, reject)()

	val request = BusinessEvent("Request Received")
		.rel.triggers(assess)

	render(
		PlantUml.opt
			.title("Example 14. Or Junction (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004]]")
			.get,
		request
	)

}
