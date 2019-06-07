package example._05_relationships

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessFunction, BusinessObject}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946003
	*/
object Ex_12_Association extends App {

	val management = BusinessFunction("Policy Management")
	val creation = BusinessFunction("Policy Creation")
		.rel.flowsTo(management, "")
	val policy = BusinessObject("Insurance Policy")
	// TODO implement associations example

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_12_Association")
			.title("Example 12. Association (Relationships)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946003")
			.get,
		creation
	))

}
