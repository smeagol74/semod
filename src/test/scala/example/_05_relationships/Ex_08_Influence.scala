package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.motivation.{Goal, Principle}

object Ex_08_Influence extends App {

	val reduceWorkload = Goal("Reduce Workload\nOf Employees")
	val decreaseCosts = Goal("Decrease Costs")
	val assignPersonalAssistant = Principle("Assign Personal\nAssistant")
		.rel.influences(reduceWorkload, "++")
		.rel.influences(decreaseCosts, "--")

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_08_Influence")
			.title("Example 8. Influence (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993")
			.get,
		assignPersonalAssistant
	))

}
