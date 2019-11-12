package example.archimate._09_application

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.application.DataObject
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946079
	*/
case object Ex_28_ApplicationPassiveStructureElements extends App with ArchimateExample {

	object db {
		val onlineInsuranceQuotation = DataObject("Online Insurance\nQuotation")
			.rel.composedOf(DataObject("Quoted\nPrice"))
			.rel.composedOf(DataObject("Terms and\nConditions"))
			.rel.composedOf(DataObject("Certificate of\nAuthenticity"))
		val autoInsuranceQuotation = DataObject("Auth Insurance\nQuotation")
			.rel.specializationOf(onlineInsuranceQuotation)
		val travelInsuranceQuotation = DataObject("Travel Insurance\nQuotation")
			.rel.specializationOf(onlineInsuranceQuotation)
	}

	render(
		PlantUml.opt
			.title("Example 28. Application Passive Structure Elements (Application)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946079]]")
			.get,
		db.onlineInsuranceQuotation
	)

}
