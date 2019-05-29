package example.business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.structure.passive.{BusinessObject, Contract, Representation}

object BusinessPassiveStructureElements extends App {

	object db {
		val claim = BusinessObject("Claim")
		val submissionForm = Representation("Submission\nForm")
  		.rel.realizes(claim)
		val claimFileSummary = Representation("Claim File\nSummary")
  		.rel.realizes(claim)
		val claimLetter = Representation("Claim\nLetter")
		val insurancePolicy = Contract("Insurance Policy")
		val policySummary = Representation("Policy\nSummary")
  		.rel.aggregates(submissionForm)
  		.rel.aggregates(claimFileSummary)
  		.rel.aggregates(claimLetter)
  		.rel.realizes(insurancePolicy)
	}

	print(Report.withDependencies(Set(
		db.insurancePolicy
	)))
}
