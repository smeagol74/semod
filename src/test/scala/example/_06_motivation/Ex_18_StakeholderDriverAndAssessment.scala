package example._06_motivation

import example.Example
import ru.kvb74.semod.opengroup.archimate.motivation.{Assessment, Driver, Stakeholder}
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946015
	*/
case object Ex_18_StakeholderDriverAndAssessment extends App with Example {

	object db {
		val cmo = Stakeholder(
			"""Chief Marketing
				|Officer (CMO)""".stripMargin)
		val ceo = Stakeholder(
			"""Chief Executive
				|Officer (CEO)""".stripMargin)
		val cfo = Stakeholder(
			"""Chief Financial
				|Officer (CFO)""".stripMargin)
		val marketShare = Driver("Market Share")
		val revenue = Driver("Revenue")
		val profitability = Driver("Profitability")
		val costs = Driver("Costs")
		val marketShareIsDeclining = Assessment(
			"""Market Share is
				|Declining""".stripMargin)
		val revenueIsDeclining = Assessment(
			"""Revenue is
				|Declining""".stripMargin)
		val profitabilityIsDeclining = Assessment(
			"""Profitability is
				|Declining""".stripMargin)
		val costOfNewCustomersIsIncreasing = Assessment(
			"""Cost Of
				|Acquiring New
				|Customers Is
				|Increasing""".stripMargin)
		val competitorsAdvancedFeatures = Assessment(
			"""Competitors Are Including
				|Advanced Features In
				|Their Service Models""".stripMargin)
		val discountsProvided = Assessment(
			"""Discounts Provided
				|To Remain
				|Competitive""".stripMargin)
		cmo
			.rel.associatedWith(marketShare)
		ceo
			.rel.associatedWith(marketShare)
			.rel.associatedWith(profitability)
		cfo
			.rel.associatedWith(profitability)
		profitability
			.rel.composedOf(revenue)
			.rel.composedOf(costs)
			.rel.associatedWith(profitabilityIsDeclining)
		marketShare
			.rel.associatedWith(marketShareIsDeclining)
		revenue
			.rel.associatedWith(revenueIsDeclining)
		costs
			.rel.associatedWith(costOfNewCustomersIsIncreasing)
		marketShareIsDeclining
			.rel.influences(revenueIsDeclining, "+")
		revenueIsDeclining
			.rel.influences(profitabilityIsDeclining, "+")
		costOfNewCustomersIsIncreasing
			.rel.influences(profitabilityIsDeclining, "+")
		competitorsAdvancedFeatures
			.rel.influences(marketShareIsDeclining, "+")
			.rel.influences(discountsProvided, "+")
		discountsProvided
			.rel.influences(marketShareIsDeclining, "-")
			.rel.influences(revenueIsDeclining, "+")
	}

	render(
		PlantUml.opt
			.title("Example 18. Stakeholder, Driver and Assessment (Motivation)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946015]]")
			.get,
		db.ceo
	)

}
