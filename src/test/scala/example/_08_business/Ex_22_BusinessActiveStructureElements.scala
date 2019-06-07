package example._08_business

import ru.kvb74.semod.opengroup.archimate.Report
import ru.kvb74.semod.opengroup.archimate.business.{BusinessActor, BusinessCollaboration, BusinessInterface, BusinessRole}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946046
	*/
object Ex_22_BusinessActiveStructureElements extends App {

	object db {

		val phone = BusinessInterface("Phone")
		val email = BusinessInterface("E-Mail")
		val webChat = BusinessInterface("Web\nChat")

		val specialist = BusinessRole("Specialist")

		val travelInsuranceClaimAnalyst = BusinessRole("Travel\nInsurance\nClaim Analyst")
			.rel.specializationOf(specialist)

		val homeInsuranceProductSpecialist = BusinessRole("Home Insurance\nProduct\nSpecialist")
			.rel.specializationOf(specialist)

		val customerServiceRepresentative = BusinessRole("Customer\nService\nRepresentative")

		val highRiskClaimsAdjudication = BusinessCollaboration("High-Risk\nClaims\nAdjudication")
			.rel.aggregates(customerServiceRepresentative)
			.rel.aggregates(specialist)

		val greg = BusinessActor("Greg")
			.rel.assignedTo(travelInsuranceClaimAnalyst)
		val joan = BusinessActor("Joan")
			.rel.assignedTo(homeInsuranceProductSpecialist)
		val larry = BusinessActor("Larry")
			.rel.assignedTo(customerServiceRepresentative)

		val contactCenter = BusinessActor("ArchiSurance Contact Center")
			.rel.composedOf(phone)
			.rel.composedOf(email)
			.rel.composedOf(webChat)
			.rel.composedOf(greg)
			.rel.composedOf(joan)
			.rel.composedOf(larry)

	}

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_22_BusinessActiveStructureElements")
			.title("Example 22. Business Active Structure Elements")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946046")
			.get,
		db.contactCenter
	))

}
