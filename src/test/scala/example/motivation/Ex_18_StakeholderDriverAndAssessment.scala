package example.motivation

import org.opengroup.archimate.Report
import org.opengroup.archimate.motivation.{Assessment, Driver, Stakeholder}

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946015
	*/
object Ex_18_StakeholderDriverAndAssessment extends App {

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

	print(Report.withDependencies(Set(
		db.ceo
	)))

}
