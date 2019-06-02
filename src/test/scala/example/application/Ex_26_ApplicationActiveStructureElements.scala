package example.application

import org.opengroup.archimate.Report
import org.opengroup.archimate.application.structure.active.{ApplicationCollaboration, ApplicationComponent, ApplicationInterface}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946069
	*/
object Ex_26_ApplicationActiveStructureElements extends App {

	object db {
		val travelWebsite = ApplicationComponent("Travel Website")
		val webServicesInterface = ApplicationInterface("Web Services\nInterface")
  		.rel.serves(travelWebsite)
		val onlineTravelInsruranceSales = ApplicationCollaboration("Online Travel\nInsurance Sales")
  		.rel.isComposedOf(webServicesInterface)
  		.rel.aggregates(ApplicationComponent("Quotation"))
  		.rel.aggregates(ApplicationComponent("Purchases"))
	}

	print(Report.withDependencies(Set(
		db.travelWebsite
	)))

}
