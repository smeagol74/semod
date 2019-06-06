package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.BusinessFunction

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946000
	*/
object Ex_10_Flow extends App {

	val settlement = BusinessFunction("Claim Settlement")
	val assessment = BusinessFunction("Claim Assessment")
		.rel.flowsTo(settlement, "decision")
	val scheduling = BusinessFunction("Scheduling")
		.rel.flowsTo(assessment, "schedule info")

	print(Report.withDependencies(
		Report.Options.empty
			.title("Example 10. Flow (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946000")
			.get,
		scheduling
	))

}
