package example.archimate._10_technology

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.ArtifactElement
import ru.kvb74.semod.opengroup.archimate.technology._
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946102
	*/
case object Ex_31_TechnologyPassiveStructureElement extends App with ArchimateExample {

	val travelInsuranceDatabase = Artifact("Travel Insurance Database")
	val databaseAccessJavaArchive = Artifact("Database Access Java Archive")
	val businessLogicJavaArchive = Artifact("Business Logic Java Archive")
	val webArchive = Artifact("Web Archive")
		.rel.composedOf(databaseAccessJavaArchive)
		.rel.composedOf(businessLogicJavaArchive)
		.rel.associatedWith(travelInsuranceDatabase)
	val purchaseApplicationWebArchive = Artifact("Purchase Application Web Archive")
		.rel.specializationOf(webArchive.asInstanceOf[ArtifactElement])
	val quotationApplicationWebArchive = Artifact("Quotation Application Web Archive")
		.rel.specializationOf(webArchive.asInstanceOf[ArtifactElement])

	render(
		PlantUml.opt
			.title("Example 31. Technology Passive Structure Element: Artifact (Technology)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946102]]")
			.get,
		webArchive
	)

}
