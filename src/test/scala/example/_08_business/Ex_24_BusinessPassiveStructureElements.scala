package example._08_business

import org.opengroup.archimate.Report
import org.opengroup.archimate.business.{BusinessObject, Contract, Representation}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946058
	*/
object Ex_24_BusinessPassiveStructureElements extends App {

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

	print(Report.withDependencies(
		Report.Options.empty
			.name("Ex_24_BusinessPassiveStructureElements")
			.title("Example 24. Business Passive Structure Elements (Business)")
			.footer("http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946058")
			.get,
		db.insurancePolicy
	))
}
