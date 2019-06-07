package example._09_application

import example.Example
import ru.kvb74.semod.opengroup.archimate.application.{ApplicationCollaboration, ApplicationComponent, ApplicationInterface}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946069
	*/
case object Ex_26_ApplicationActiveStructureElements extends App with Example {

	object db {
		val travelWebsite = ApplicationComponent("Travel Website")
		val webServicesInterface = ApplicationInterface("Web Services\nInterface")
			.rel.serves(travelWebsite)
		val onlineTravelInsruranceSales = ApplicationCollaboration("Online Travel\nInsurance Sales")
			.rel.composedOf(webServicesInterface)
			.rel.aggregates(ApplicationComponent("Quotation"))
			.rel.aggregates(ApplicationComponent("Purchases"))
	}

	render(
		PlantUml.opt
			.title("Example 26. Application Active Structure Elements (Application)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946069]]")
			.get,
		db.travelWebsite
	)

}
