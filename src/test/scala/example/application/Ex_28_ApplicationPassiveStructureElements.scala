package example.application

import org.opengroup.archimate.Report
import org.opengroup.archimate.application.DataObject

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

	print(Report.withDependencies(Some("Example 28. Application Passive Structure Elements (Application)"), Set(
		db.onlineInsuranceQuotation
	)))

}
