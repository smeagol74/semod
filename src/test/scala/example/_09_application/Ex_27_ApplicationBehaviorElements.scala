package example._09_application

import example.Example
import ru.kvb74.semod.opengroup.archimate.application._
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946076
	*/
case object Ex_27_ApplicationBehaviorElements extends App with Example {

	object db {
		val obtainTravelInsurance = ApplicationProcess("Obtain Travel Insurance")

		val requestForAQuotation = ApplicationEvent("Request for\na Quotation")
			.rel.triggers(obtainTravelInsurance)

		val getQuotation = ApplicationService("Get Quotation")
			.rel.serves(obtainTravelInsurance)

		val purchaseQuotedInsurance = ApplicationService("Purchase Quoted\nInsurance")
			.rel.serves(obtainTravelInsurance)

		val prepareQuotation = ApplicationFunction("Prepare\nQuotation")
			.rel.realizes(getQuotation)

		val finalizePurchase = ApplicationFunction("Finalize\nPurchase")
			.rel.realizes(purchaseQuotedInsurance)

		val purchaseTravelInsurance = ApplicationInteraction("PurchaseTravelInsurance")
			.rel.composedOf(prepareQuotation)
			.rel.composedOf(finalizePurchase)
	}

	render(
		PlantUml.opt
			.title("Example 27. Application Behavior Elements (Application)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946076]]")
			.get,
		db.purchaseTravelInsurance
	)

}
