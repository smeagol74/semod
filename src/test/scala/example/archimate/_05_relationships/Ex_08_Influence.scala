package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.motivation.{Goal, Principle}
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_08_Influence extends App with ArchimateExample {

	val reduceWorkload = Goal("Reduce Workload\nOf Employees")
	val decreaseCosts = Goal("Decrease Costs")
	val assignPersonalAssistant = Principle("Assign Personal\nAssistant")
		.rel.influences(reduceWorkload, "++")
		.rel.influences(decreaseCosts, "--")

	render(
		PlantUml.opt
			.title("Example 8. Influence (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945993]]")
			.get,
		assignPersonalAssistant
	)

}
