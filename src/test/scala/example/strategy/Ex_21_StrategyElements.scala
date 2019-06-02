package example.strategy

import org.opengroup.archimate.motivation.{Goal, Outcome}
import org.opengroup.archimate.strategy.behavior.{Capability, CourseOfAction}
import org.opengroup.archimate.strategy.structure.Resource

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap07.html#_Toc489946036
	*/
object Ex_21_StrategyElements extends App {
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

}
