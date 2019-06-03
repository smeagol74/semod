package example.business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessActor, BusinessCollaboration, BusinessInterface, BusinessRole}

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
			.rel.isSpecializationOf(specialist)

		val homeInsuranceProductSpecialist = BusinessRole("Home Insurance\nProduct\nSpecialist")
			.rel.isSpecializationOf(specialist)

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
			.rel.isComposedOf(phone)
			.rel.isComposedOf(email)
			.rel.isComposedOf(webChat)
			.rel.isComposedOf(greg)
			.rel.isComposedOf(joan)
			.rel.isComposedOf(larry)

	}

	print(Report.withDependencies(Set(
		db.contactCenter
	)))

}
