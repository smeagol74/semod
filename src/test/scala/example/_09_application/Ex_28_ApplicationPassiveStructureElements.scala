package example._09_application

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.application.DataObject

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946079
	*/
object Ex_28_ApplicationPassiveStructureElements extends App {

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

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_28_ApplicationPassiveStructureElements")
			.title("Example 28. Application Passive Structure Elements (Application)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946079")
			.get,
		db.onlineInsuranceQuotation
	))

}
