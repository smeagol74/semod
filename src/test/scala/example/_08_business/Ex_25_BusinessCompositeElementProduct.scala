package example._08_business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessService, Contract, Product}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946061
	*/
object Ex_25_BusinessCompositeElementProduct extends App {

	object db {

		val insurance = Product("Insurance")
			.rel.composedOf(Contract("Insurance Policy"))
			.rel.composedOf(
			BusinessService("Customer\nService")
				.rel.aggregates(BusinessService("Application"))
				.rel.aggregates(BusinessService("Renewal"))
				.rel.aggregates(BusinessService("Claims\nProcessing"))
				.rel.aggregates(BusinessService("Appeal"))
		)

		val autoInsurance = Product("Auto Insurance")
			.rel.specializationOf(insurance)
			.rel.composedOf(Contract("Drive Well and\nSave Agreement"))
			.rel.composedOf(BusinessService("Drive Well\nand Save"))
	}

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_25_BusinessCompositeElementProduct")
			.title("Example 25. Business Composite Element Product (Business)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946061")
			.get,
		db.insurance
	))

}
