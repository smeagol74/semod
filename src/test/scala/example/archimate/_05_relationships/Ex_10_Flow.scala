package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.BusinessFunction
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946000
	*/
case object Ex_10_Flow extends App with ArchimateExample {

	val settlement = BusinessFunction("Claim Settlement")
	val assessment = BusinessFunction("Claim Assessment")
		.rel.flowsTo(settlement, "decision")
	val scheduling = BusinessFunction("Scheduling")
		.rel.flowsTo(assessment, "schedule info")

	render(
		PlantUml.opt
			.title("Example 10. Flow (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946000]]")
			.get,
		scheduling
	)

}
