package example._06_motivation

import example.Example
import ru.kvb74.semod.opengroup.archimate.application.{ApplicationService, DataObject}
import ru.kvb74.semod.opengroup.archimate.motivation.{Meaning, Stakeholder, Value}
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode
import ru.kvb74.semod.plantuml.PlantUml

/**
	* This is example of
	*
	* @see [[http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946026 Archimate 3.0.1 / Motivation Elements / Meaning and Value / Example]]
	*/
case object Ex_20_MeaningAndValue extends App with Example {

	object db {
		val costEfficiency = Value("Cost Efficiency")
		val beingInformed = Value("Being Informed")
		val peaceOfMind = Value("Peace of Mind")
			.rel.composedOf(Value("Certainty"))

		val insurer = Stakeholder("Insurer")
			.rel.associatedWith(costEfficiency)
		val customer = Stakeholder("Customer")
			.rel.associatedWith(beingInformed)
			.rel.associatedWith(peaceOfMind)

		val message = DataObject("Message")

		val pushNotification = ApplicationService("Push Notification")
			.rel.associatedWith(costEfficiency)
			.rel.associatedWith(beingInformed)
			.rel.associatedWith(peaceOfMind)
			.rel.accesses(message, AccessMode.WRITE)

		val confirmationOfReceipt = DataObject(
			"""Confirmation Of
				|Receipt Message""".stripMargin)
			.rel.specializationOf(message)
			.rel.associatedWith(Meaning(
			"""Claim Has
				|Been
				|Received""".stripMargin))

		val reviewCompelete = DataObject(
			"""Review Complete
				|Message""".stripMargin)
			.rel.specializationOf(message)
			.rel.associatedWith(Meaning(
			"""Claim Review
				|Complete""".stripMargin))

		val paymentComplete = DataObject(
			"""Payment Complete
				|Message""".stripMargin)
			.rel.specializationOf(message)
			.rel.associatedWith(Meaning(
			"""Claim Has
				|Been Paid""".stripMargin))
	}

	render(
		PlantUml.opt
			.title("Example 20. Meaning and Value (Motivation)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946026]]")
			.get,
		db.insurer,
		db.customer
	)

}
