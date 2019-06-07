package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessEvent, BusinessProcess}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004
	*/
object Ex_14_OrJunction extends App {

	val accept = BusinessProcess("Accept Request")
	val reject = BusinessProcess("Reject Request")

	val assess = BusinessProcess("Assess Request")
		.rel.junction.triggers.or(accept, reject)

	val request = BusinessEvent("Request Received")
		.rel.triggers(assess)

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_14_OrJunction")
			.title("Example 14. Or Junction (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004")
			.get,
		request
	))

}
