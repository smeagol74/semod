package example._13_implementation

import example.Example
import ru.kvb74.semod.opengroup.archimate.implementation._
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode
import ru.kvb74.semod.plantuml.PlantUml

case object Ex_34_ImplementationAndMigrationElements extends App with Example {

	lazy val baseline = Plateau("Baseline")
		.rel.triggers(strategicPlanComplete)

	lazy val strategicPlanComplete = Plateau("Strategic Plan Complete")
		.rel.triggers(applicationServiceLayerInPlace)
		.rel.junction.and(businessPlan, architecture, roadmap).realizesThis

	lazy val applicationServiceLayerInPlace = Plateau("Application Services Layer In Place")
		.rel.triggers(nextGenerationServicesInPlace)

	lazy val nextGenerationServicesInPlace = Plateau("Next Generation Services In Place")

	val knowledgeOfHowToAddressCustomerNeeds = Gap("Knowledge Of How To Address Customer Needs")
		.rel.associatedWith(baseline, strategicPlanComplete)

	val programmaticInternetAccessToCoreSystemsAndData = Gap("Programmatic Internet Access To Core Systems And Data")
		.rel.associatedWith(strategicPlanComplete, applicationServiceLayerInPlace)

	val consumerInternetAndMobileAccessToInsuranceServices = Gap("Consumer Internet And Mobile Access To Insurance Services")
		.rel.associatedWith(applicationServiceLayerInPlace, nextGenerationServicesInPlace)

	lazy val businessPlan = Deliverable("Business Plan")
	lazy val architecture = Deliverable("Architecture")
	lazy val roadmap = Deliverable("Roadmap")

	val servicesPlatrofm = Deliverable("Services Platform")
		.rel.realizes(applicationServiceLayerInPlace)

	val businessServices = Deliverable("Business Services")
		.rel.realizes(nextGenerationServicesInPlace)

	val programBrief = Deliverable("Program Brief")

	lazy val programApproved = ImplementationEvent("Program Approved")
		.rel.triggers(architectureAndPlanning)
		.rel.accesses(programBrief, AccessMode.WRITE)

	lazy val architectureAndPlanning = WorkPackage("Architecture And Planning")
		.rel.accesses(programBrief, AccessMode.READ)
		.rel.realizes(businessPlan)
		.rel.realizes(architecture)
		.rel.realizes(roadmap)
		.rel.triggers(applicationServicesLayerDevelopment)

	lazy val applicationServicesLayerDevelopment = WorkPackage("Application Services Layer Development")
		.rel.accesses(roadmap, AccessMode.READ)
		.rel.realizes(servicesPlatrofm)
		.rel.triggers(businessServicesDevelopment)

	lazy val businessServicesDevelopment = WorkPackage("Business Services Development")
		.rel.accesses(servicesPlatrofm, AccessMode.READ)
		.rel.realizes(businessServices)
		.rel.triggers(programComplete)

	lazy val programComplete = ImplementationEvent("Program Complete")

	val nextGenerationServicesProgram = WorkPackage("Next Generation Services Program")
		.rel.composedOf(architectureAndPlanning)
		.rel.composedOf(applicationServicesLayerDevelopment)
		.rel.composedOf(businessServicesDevelopment)

	render(
		PlantUml.opt
			.title("Example 34. Implementation and Migration Elements (Implementation and Migration)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap13.html#_Toc489946127]]")
			.get,
		programApproved,
		nextGenerationServicesProgram
	)

}
