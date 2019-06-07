package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.BusinessObject
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_03_Aggregation extends App with Example {
	val customerFile = BusinessObject("Customer File")
		.rel.aggregates(BusinessObject("Insurance Policy"))
		.rel.aggregates(BusinessObject("Insurance Claim"))

	render(
		PlantUml.opt
			.title("Example 3. Aggregation (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489945991]]")
			.get,
		customerFile
	)

}
