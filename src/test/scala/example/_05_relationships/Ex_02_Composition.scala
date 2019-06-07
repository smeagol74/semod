package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.BusinessFunction
import org.opengroup.archimate.meta.element.business.BusinessFunctionElement

object Ex_02_Composition extends App {

	val financialProcessing = BusinessFunction("Financial Processing")
		.rel.composedOf(BusinessFunction("Accounting").asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(BusinessFunction("Payment").asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(BusinessFunction("Billing").asInstanceOf[BusinessFunctionElement])

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_02_Composition")
			.title("Example 2. Composition (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945990")
			.get,
		financialProcessing
	))

}
