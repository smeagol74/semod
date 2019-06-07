package example._05_relationships

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.BusinessObject

object Ex_03_Aggregation extends App {
	val customerFile = BusinessObject("Customer File")
		.rel.aggregates(BusinessObject("Insurance Policy"))
		.rel.aggregates(BusinessObject("Insurance Claim"))

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_03_Aggregation")
			.title("Example 3. Aggregation (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945991")
			.get,
		customerFile
	))

}
