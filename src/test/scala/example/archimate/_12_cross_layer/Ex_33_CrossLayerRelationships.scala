package example.archimate._12_cross_layer

import example.archimate.ArchimateExample
import ru.kvb74.semod.meta.relationship.dependency.AccessMode
import ru.kvb74.semod.opengroup.archimate.application.{ApplicationComponent, ApplicationService, DataObject}
import ru.kvb74.semod.opengroup.archimate.business._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessProcessElement
import ru.kvb74.semod.opengroup.archimate.technology._
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap12.html#_Toc489946118
	*/
case object Ex_33_CrossLayerRelationships extends App with ArchimateExample {

	val insurant = BusinessRole("Insurant")

	val customer = BusinessActor("Customer")
		.rel.assignedTo(insurant)

	val claimsRegistration = BusinessService("Claims Registration")
		.rel.serves(insurant)

	val claimsAcceptance = BusinessService("Claims Acceptance")
		.rel.serves(insurant)

	val claimsPayment = BusinessService("Claims Payment")
		.rel.serves(insurant)

	val customerInformation = BusinessObject("Customer Information")

	lazy val register = BusinessProcess("Register")
		.rel.realizes(claimsRegistration)
		.rel.triggers(accept)
		.rel.accesses(customerInformation, AccessMode.WRITE)

	lazy val accept = BusinessProcess("Accept")
		.rel.realizes(claimsAcceptance)
		.rel.triggers(adjudicate)

	lazy val adjudicate = BusinessProcess("Adjudicate")
		.rel.triggers(pay)

	lazy val pay = BusinessProcess("Pay")
		.rel.realizes(claimsPayment)

	val processClaims = BusinessProcess("Process Claims")
		.rel.composedOf(register.asInstanceOf[BusinessProcessElement])
		.rel.composedOf(accept.asInstanceOf[BusinessProcessElement])
		.rel.composedOf(adjudicate.asInstanceOf[BusinessProcessElement])
		.rel.composedOf(pay.asInstanceOf[BusinessProcessElement])

	val insurer = BusinessRole("Insurer")
		.rel.assignedTo(processClaims)

	val archiSurance = BusinessActor("ArchiSurance")
		.rel.assignedTo(insurer)

	val customerDataManagement = ApplicationService("Customer Data Management")
		.rel.serves(register)

	val paymentProcessing = ApplicationService("Payment Processing")
		.rel.serves(pay)

	val customerData = DataObject("Customer Data")
		.rel.realizes(customerInformation)

	val crmSystem = ApplicationComponent("CRM System")
		.rel.accesses(customerData, AccessMode.WRITE)

	val financialApplication = ApplicationComponent("Financial application")

	val customerDatabaseTables = Artifact("Customer Database Tables")
		.rel.realizes(customerData)

	val databaseManagement = TechnologyService("Database Management")
		.rel.serves(crmSystem)
		.rel.accesses(customerDatabaseTables, AccessMode.WRITE)

	val databaseAccessJavaArchive = Artifact("Database Access Java Archive")
		.rel.realizes(crmSystem)

	val databaseManagementSystem = SystemSoftware("Database Management System")
		.rel.realizes(databaseManagement)
		.rel.assignedTo(databaseAccessJavaArchive)

	val applicationHosting = TechnologyService("Application Hosting")
		.rel.serves(crmSystem)
		.rel.serves(financialApplication)

	val financialApplicationWebArchive = Artifact("Financial Application Web Archive")
		.rel.realizes(financialApplication)

	val applicationServer = SystemSoftware("Application Server")
		.rel.assignedTo(financialApplicationWebArchive)
		.rel.realizes(applicationHosting)

	val bladeSystem = Device("Blade System")
		.rel.assignedTo(databaseManagementSystem)
		.rel.assignedTo(applicationServer)

	render(
		PlantUml.opt
			.title("Example 33. Cross-Layer Relationships (Cross-Layer)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap12.html#_Toc489946118]]")
			.get,
		bladeSystem
	)

}
