package example._08_business

import example.Example
import ru.kvb74.semod.opengroup.archimate.business.{BusinessObject, Contract, Representation}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946058
	*/
case object Ex_24_BusinessPassiveStructureElements extends App with Example {

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

	render(
		PlantUml.opt
			.title("Example 24. Business Passive Structure Elements (Business)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap08.html#_Toc489946058]]")
			.get,
		db.insurancePolicy
	)
}
