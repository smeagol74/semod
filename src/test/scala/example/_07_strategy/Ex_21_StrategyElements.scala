package example._07_strategy

import example.Example
import ru.kvb74.semod.opengroup.archimate.motivation.{Goal, Outcome}
import ru.kvb74.semod.opengroup.archimate.strategy.{Capability, CourseOfAction, Resource}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap07.html#_Toc489946036
	*/
case object Ex_21_StrategyElements extends App with Example {
	val decreaseCosts = Goal("Decrease Costs")
	val increaseRevenue = Goal("Increase Revenue")

	val incProfit = Goal("Increase Profit")
		.rel.aggregates(decreaseCosts)
		.rel.aggregates(increaseRevenue)

	val decreasedCosts = Outcome("Decreased\nCosts")
		.rel.influences(decreaseCosts, "+")
	val lossOfCustomers = Outcome("Loss of\nCustomers")
		.rel.influences(increaseRevenue, "-")

	val centralizeItSystems = CourseOfAction("Centralize IT\nSystems")
		.rel.influences(decreasedCosts, "+")
	val standartizeProducts = CourseOfAction("Standartize\nProducts")
		.rel.influences(decreasedCosts, "+")
		.rel.influences(lossOfCustomers, "+")

	val operationalExcellence = CourseOfAction("Operational\nExcellence")
		//  	.rel.associatedWith(decreaseCosts) ??? этой связи нет в спецификации или я её где-то пропустил TODO найти и починить
		.rel.aggregates(centralizeItSystems)
		.rel.aggregates(standartizeProducts)

	val itManagementAndOperations = Capability("IT\nManagement &\nOperations")
		.rel.realizes(centralizeItSystems)
	val productManagement = Capability("Product\nManagement")
		.rel.realizes(standartizeProducts)

	val humarResources = Resource("Human\nResources")
		.rel.assignedTo(itManagementAndOperations)
	val ieResources = Resource("IT\nResources")
		.rel.assignedTo(itManagementAndOperations)

	//	val headquarters = Location("Headquarters")

	render(
		PlantUml.opt
			.title("Example 21. Strategy Elements")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap07.html#_Toc489946036]]")
			.get,
		centralizeItSystems
	)
}
