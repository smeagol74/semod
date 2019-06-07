package example._09_application

import org.opengroup.archimate.Report
import org.opengroup.archimate.application.{ApplicationCollaboration, ApplicationComponent, ApplicationInterface}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946069
	*/
object Ex_26_ApplicationActiveStructureElements extends App {

	object db {
		val travelWebsite = ApplicationComponent("Travel Website")
		val webServicesInterface = ApplicationInterface("Web Services\nInterface")
			.rel.serves(travelWebsite)
		val onlineTravelInsruranceSales = ApplicationCollaboration("Online Travel\nInsurance Sales")
			.rel.composedOf(webServicesInterface)
			.rel.aggregates(ApplicationComponent("Quotation"))
			.rel.aggregates(ApplicationComponent("Purchases"))
	}

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_26_ApplicationActiveStructureElements")
			.title("Example 26. Application Active Structure Elements (Application)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946069")
			.get,
		db.travelWebsite
	))

}
