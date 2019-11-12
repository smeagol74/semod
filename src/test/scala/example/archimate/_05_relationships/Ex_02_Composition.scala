package example.archimate._05_relationships

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.business.BusinessFunction
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessFunctionElement
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_02_Composition extends App with ArchimateExample {

	val financialProcessing = BusinessFunction("Financial Processing")
		.rel.composedOf(BusinessFunction("Accounting").asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(BusinessFunction("Payment").asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(BusinessFunction("Billing").asInstanceOf[BusinessFunctionElement])

	render(
		PlantUml.opt
			.title("Example 2. Composition (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945990]]")
			.get,
		financialProcessing
	)
}
