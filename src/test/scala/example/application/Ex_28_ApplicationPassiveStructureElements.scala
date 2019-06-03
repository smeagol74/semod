package example.application

import org.opengroup.archimate.Report
import org.opengroup.archimate.application.DataObject

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946079
	*/
object Ex_28_ApplicationPassiveStructureElements extends App {

	object db {
		val onlineInsuranceQuotation = DataObject("Online Insurance\nQuotation")
			.rel.isComposedOf(DataObject("Quoted\nPrice"))
			.rel.isComposedOf(DataObject("Terms and\nConditions"))
			.rel.isComposedOf(DataObject("Certificate of\nAuthenticity"))
		val autoInsuranceQuotation = DataObject("Auth Insurance\nQuotation")
			.rel.isSpecializationOf(onlineInsuranceQuotation)
		val travelInsuranceQuotation = DataObject("Travel Insurance\nQuotation")
			.rel.isSpecializationOf(onlineInsuranceQuotation)
	}

	print(Report.withDependencies(Set(
		db.onlineInsuranceQuotation
	)))

}
