package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.BusinessObject

object Ex_03_Aggregation extends App {
	val customerFile = BusinessObject("Customer File")
		.rel.aggregates(BusinessObject("Insurance Policy"))
		.rel.aggregates(BusinessObject("Insurance Claim"))

	print(Report.withDependencies(
		Report.Options.empty
			.title("Example 3. Aggregation (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945991")
			.get,
		customerFile
	))

}
