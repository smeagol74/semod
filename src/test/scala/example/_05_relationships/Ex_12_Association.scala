package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessFunction, BusinessObject}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946003
	*/
case object Ex_12_Association extends App with Example {

	val management = BusinessFunction("Policy Management")
	val creation = BusinessFunction("Policy Creation")
		.rel.flowsTo(management, "Insurance Policy")
	val policy = BusinessObject("Insurance Policy")
  	.rel.junction.associatedWith.and(creation, management)()
		.rel.associatedWith(BusinessObject("Customer File"))
		.rel.associatedWith(BusinessObject("Insured Object"))

	render(
		PlantUml.opt
			.title("Example 12. Association (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946003]]")
			.get,
		creation,
		policy
	)

}
