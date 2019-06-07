package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessFunction, BusinessService}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004
	*/
case object Ex_13_AndJunction extends App with Example {

	val sales = BusinessFunction("Sales")
	val finance = BusinessFunction("Finance")

	val invoicing = BusinessService("Invoicing")
		.rel.junction.and(sales, finance).realizesThis

	render(
		PlantUml.opt
			.title("Example 13. (And) Junction (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946004]]")
			.get,
		invoicing
	)

}
