package example._04_genericMetamodel

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessObject, BusinessProcess, BusinessService}
import ru.kvb74.semod.opengroup.archimate.composite.Grouping
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap04.html#_Toc489945986
	*/
case object Ex_01_Grouping extends App with Example {

	val service = BusinessService("Service")

	val obj = BusinessObject("Object")
	val proc2 = BusinessProcess("Process 2")
	val proc1 = BusinessProcess("Process 1")
		.rel.triggers(proc2)
		.rel.accesses(obj, AccessMode.WRITE)

	val grouping = Grouping("Grouping")
		.rel.aggregates(obj)
		.rel.aggregates(proc1)
		.rel.aggregates(proc2)
		.rel.realizes(service)

	render(
		PlantUml.opt
			.title("Example 1. Grouping (Composite)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap04.html#_Toc489945986]]")
			.get,
		grouping
	)
}
