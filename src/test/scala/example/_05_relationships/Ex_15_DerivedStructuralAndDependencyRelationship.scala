package example._05_relationships

import example.Example
import ru.kvb74.semod.opengroup.archimate.application.ApplicationService
import ru.kvb74.semod.opengroup.archimate.business.{BusinessFunction, BusinessProcess, BusinessService}
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessFunctionElement
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_15_DerivedStructuralAndDependencyRelationship extends App with Example {

	val invoicing = BusinessProcess("Invoicing and Collections")

	val accountingSvc = BusinessService("Accounting Service")
		.rel.serves(invoicing)

	val billingSvc = BusinessService("Billing Service")
		.rel.serves(invoicing)

	val paymentSvc = BusinessService("Payment Service")
		.rel.serves(invoicing)

	val accounting = BusinessFunction("Accounting")
		.rel.realizes(accountingSvc)

	val billing = BusinessFunction("Billing")
		.rel.realizes(billingSvc)

	val payment = BusinessFunction("Payment")
		.rel.realizes(paymentSvc)

	val financialProcessing = BusinessFunction("Financial Processing")
		.rel.composedOf(accounting.asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(billing.asInstanceOf[BusinessFunctionElement])
		.rel.composedOf(payment.asInstanceOf[BusinessFunctionElement])

	val financialApplication = ApplicationService("Financial Application")
		.rel.serves(financialProcessing)
		.rel.serves(invoicing) // this relation should be derived automatically

	render(
		PlantUml.opt
			.title("Example 15. Derived Structural and Dependency Relationship (Relationships)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap05.html#_Toc489946007]]")
			.get,
		financialApplication
	)

}
