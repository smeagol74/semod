package example.business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business._

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946046
	*/
object Ex_23_BusinessBehaviorElements extends App {

	object db {
		val claimsProcessing = BusinessService("Claims Processing")

		val closeClaim = BusinessProcess("Close\nClaim")

		// TODO improve flowsTo with junctions
		val notifyCustomer = BusinessProcess("Notify\nCustomer")
			.rel.flowsTo(closeClaim)

		// TODO improve flowsTo with junctions
		val payClaim = BusinessProcess("Play\nClaim")
			.rel.flowsTo(closeClaim)

		// TODO improve flowsTo with junctions
		val adjudcateStandardClaim = BusinessProcess("Adjudcate\nStandard Claim")
			.rel.flowsTo(notifyCustomer)
			.rel.flowsTo(payClaim)

		// TODO improve flowsTo with junctions
		val adjudcateHighRiskClaim = BusinessInteraction("Adjudcate\nHigh-Risk Claim")
			.rel.flowsTo(notifyCustomer)
  		.rel.flowsTo(payClaim)

		// TODO improve flowsTo with junctions
		val assignClaim = BusinessProcess("Assign\nClaim")
			.rel.flowsTo(adjudcateStandardClaim)
			.rel.flowsTo(adjudcateHighRiskClaim)

		val acceptClaim = BusinessProcess("Accept\nClaim")
			.rel.flowsTo(assignClaim)
		val claimFiled = BusinessEvent("Claim Filed")
			.rel.flowsTo(acceptClaim)

		val claimsAdministration = BusinessFunction("Claims Administration")
			.rel.realizes(claimsProcessing)
  		.rel.isComposedOf(acceptClaim)
  		.rel.isComposedOf(assignClaim)
			.rel.isComposedOf(adjudcateStandardClaim)
			.rel.isComposedOf(adjudcateHighRiskClaim)
  		.rel.isComposedOf(notifyCustomer)
  		.rel.isComposedOf(payClaim)
  		.rel.isComposedOf(closeClaim)

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

	print(Report.withDependencies(Set(
		db.claimsProcessing
	)))

}
