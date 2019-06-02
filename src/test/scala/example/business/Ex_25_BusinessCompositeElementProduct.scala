package example.business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.behavior.BusinessService
import org.opengroup.archimate.business.composite.Product
import org.opengroup.archimate.business.structure.passive.Contract

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946061
	*/
object Ex_25_BusinessCompositeElementProduct extends App {

	object db {

		val insurance = Product("Insurance")
			.rel.isComposedOf(Contract("Insurance Policy"))
			.rel.isComposedOf(
			BusinessService("Customer\nService")
				.rel.aggregates(BusinessService("Application"))
				.rel.aggregates(BusinessService("Renewal"))
				.rel.aggregates(BusinessService("Claims\nProcessing"))
				.rel.aggregates(BusinessService("Appeal"))
		)

		val autoInsurance = Product("Auto Insurance")
			.rel.isSpecializationOf(insurance)
			.rel.isComposedOf(Contract("Drive Well and\nSave Agreement"))
			.rel.isComposedOf(BusinessService("Drive Well\nand Save"))
	}

	print(Report.withDependencies(Set(
		db.insurance
	)))

}
