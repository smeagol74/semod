package example.motivation

import org.opengroup.archimate.Report
import org.opengroup.archimate.motivation._

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap06.html#_Toc489946022
	*/
object Ex_19_GoalOutcomePrincipleRequirementAndConstraint extends App {

	object db {
		val improvePortability = Goal(
			"""Improve
				|Portability Of
				|Service Offering""".stripMargin)
		val increasedProfit = Outcome(
			"""Increased
				|Profit""".stripMargin)
			.rel.realizes(improvePortability)
		val increasedRevenue = Outcome(
			"""Increased
				|Revenue""".stripMargin)
			.rel.influences(increasedProfit, "+")
		val reducedCost = Outcome(
			"""Reduced Cost Of
				|Customer acquisition""".stripMargin)
			.rel.influences(increasedProfit, "+")
		val increasedMarketShare = Outcome(
			"""Increased Market
				|Share""".stripMargin)
			.rel.influences(increasedRevenue, "+")
		val serveCustomersWheneverTheyNeedOurHelp = Principle(
			"""Serve Customers
				|Whenever They
				|Need Our Help""".stripMargin)
			.rel.realizes(increasedRevenue)
		val serveCustomersWhereverTheyAre = Principle(
			"""Serve Customers
				|Wherever They Are""".stripMargin)
			.rel.realizes(increasedMarketShare)
		val respondToChangindNeeds = Principle(
			"""Respond To Changing
				|Customer Needs,
				|Preferences, And Expectations
				|Quickly And Efficiently""".stripMargin)
			.rel.realizes(reducedCost)
		val servicesMobile = Requirement(
			"""Services Shell Be
				|Accessible Through
				|Mobile Browsers""".stripMargin)
			.rel.realizes(serveCustomersWhereverTheyAre)
		val popularMobile = Requirement(
			"""Mobile Applications Shall
				|Run On All Popular
				|Mobile Platforms""".stripMargin)
			.rel.realizes(serveCustomersWheneverTheyNeedOurHelp)
		val mobileCrossPlatform = Constraint(
			"""Mobile Applications Shall Be
				|Built With Cross-Platform
				|Frameworks""".stripMargin)
	}

	print(Report.withDependencies(Set(
		db.improvePortability
	)))
}
