package example.archimate._10_technology

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.meta.element.technology.TechnologyFunctionElement
import ru.kvb74.semod.opengroup.archimate.technology._
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946098
	*/
case object Ex_30_TechnologyBehaviorElements extends App with ArchimateExample {

	val remoteDataReplication = TechnologyProcess("Remote Data Replication")
	val databaseUpdate = TechnologyEvent("Database Update")
		.rel.triggers(remoteDataReplication)
	val replicateDatabaseUpdates = TechnologyService("Replicate Database Updates")
		.rel.serves(remoteDataReplication)
	val handleLocalUpdates = TechnologyFunction("Handle Local Updates")
	val handleRemoteUpdates = TechnologyFunction("Handle Remote Updates")
	val monitorReplicationStatus = TechnologyFunction("Monitor Replication Status")
	val administrateReplication = TechnologyFunction("Administrate Replication")
		.rel.flowsTo(handleLocalUpdates, "")
		.rel.flowsTo(handleRemoteUpdates, "")
		.rel.flowsTo(monitorReplicationStatus, "")
	val databaseReplication = TechnologyFunction("Database Replication")
		.rel.realizes(replicateDatabaseUpdates)
		.rel.composedOf(administrateReplication.asInstanceOf[TechnologyFunctionElement])
		.rel.composedOf(handleLocalUpdates.asInstanceOf[TechnologyFunctionElement])
		.rel.composedOf(handleRemoteUpdates.asInstanceOf[TechnologyFunctionElement])
		.rel.composedOf(monitorReplicationStatus.asInstanceOf[TechnologyFunctionElement])

	render(
		PlantUml.opt
			.title("Example 30. Technology Behavior Elements (Technology)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946098]]")
			.get,
		remoteDataReplication
	)

}
