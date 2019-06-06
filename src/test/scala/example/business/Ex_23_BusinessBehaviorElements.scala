package example.business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business._
import org.opengroup.archimate.meta.relationship.Junction

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946053
	*/
object Ex_23_BusinessBehaviorElements extends App {

	object db {
		val claimsProcessing = BusinessService("Claims Processing")

		val notifyCustomer = BusinessProcess("Notify\nCustomer")

		val payClaim = BusinessProcess("Play\nClaim")

		val closeClaim = BusinessProcess("Close\nClaim")
			.rel.junction.and(notifyCustomer, payClaim).triggersThis

		val adjudcateStandardClaim = BusinessProcess("Adjudcate\nStandard Claim")

		val adjudcateHighRiskClaim = BusinessInteraction("Adjudcate\nHigh-Risk Claim")

		Junction
			.or(adjudcateStandardClaim, adjudcateHighRiskClaim)
			.triggers
			.and(notifyCustomer, payClaim)

		val assignClaim = BusinessProcess("Assign\nClaim")
			.rel.junction.triggers.or(adjudcateStandardClaim, adjudcateHighRiskClaim)

		val acceptClaim = BusinessProcess("Accept\nClaim")
			.rel.triggers(assignClaim)
		val claimFiled = BusinessEvent("Claim Filed")
			.rel.triggers(acceptClaim)

		val claimsAdministration = BusinessFunction("Claims Administration")
			.rel.realizes(claimsProcessing)
			.rel.composedOf(acceptClaim)
			.rel.composedOf(assignClaim)
			.rel.composedOf(adjudcateStandardClaim)
			.rel.composedOf(adjudcateHighRiskClaim)
			.rel.composedOf(notifyCustomer)
			.rel.composedOf(payClaim)
			.rel.composedOf(closeClaim)

		val customerServiceRepresentative = BusinessRole("Customer\nService\nRepresentative")
			.rel.assignedTo(acceptClaim)

		val specialist = BusinessRole("Specialist")
			.rel.assignedTo(adjudcateStandardClaim)

		val highRiskClaimsAdjudcation = BusinessCollaboration("High-Risk\nClaims\nAdjudcation")
			.rel.aggregates(customerServiceRepresentative)
			.rel.aggregates(specialist)
			.rel.assignedTo(assignClaim)
			.rel.assignedTo(adjudcateHighRiskClaim)
	}

	print(Report.withDependencies(Some("Example 23. Business Behavior Elemenst (Business)"), Set(
		db.claimsProcessing
	)))

}
