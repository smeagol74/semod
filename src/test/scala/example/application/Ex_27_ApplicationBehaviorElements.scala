package example.application

import org.opengroup.archimate.Report
import org.opengroup.archimate.application.behavior._

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap09.html#_Toc489946076
	*/
object Ex_27_ApplicationBehaviorElements extends App {
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
  		.rel.isComposedOf(prepareQuotation)
  		.rel.isComposedOf(finalizePurchase)
	}

	print(Report.withDependencies(Set(
		db.purchaseTravelInsurance
	)))

}
