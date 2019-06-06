package example._04_genericMetamodel

import org.opengroup.archimate.business.{BusinessObject, BusinessProcess, BusinessService}

object Ex_01_Grouping extends App {

	val service = BusinessService("Service")

	val obj = BusinessObject("Object")
	val proc2 = BusinessProcess("Process 2")
	val proc1 = BusinessProcess("Process 1")
		.rel.triggers(proc2)
//		.rel.accesses(obj)

//	val grouping = Grouping("Grouping")
//  	.rel.aggregates(obj)
//  	.rel.aggregates(proc1)
//  	.rel.aggregates(proc2)
//  	.rel.realizes(service)

	print("Hello")
}
