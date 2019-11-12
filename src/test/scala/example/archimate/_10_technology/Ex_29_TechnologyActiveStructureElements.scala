package example.archimate._10_technology

import example.archimate.ArchimateExample
import ru.kvb74.semod.opengroup.archimate.technology._
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946091
	*/
case object Ex_29_TechnologyActiveStructureElements extends App with ArchimateExample {

	val openSourceOperatingSystem = SystemSoftware("Open Source Operating System")
	val quotationVirtualHost = Node("Quotation Virtual Host")
		.rel.aggregates(openSourceOperatingSystem)

	val proprietaryOperatingSystem = SystemSoftware("Proprietary Operating System")
	val purchaseVirtualHost = Node("Purchase Virtual Host")
		.rel.aggregates(proprietaryOperatingSystem)

	val hypervisor = SystemSoftware("Hypervisor")
		.rel.assignedTo(openSourceOperatingSystem)
		.rel.assignedTo(proprietaryOperatingSystem)

	val eCommerceHosting = TechnologyCollaboration("E-Commerce Hosting")
		.rel.aggregates(quotationVirtualHost)
		.rel.aggregates(purchaseVirtualHost)
		.rel.aggregates(hypervisor)

	val managementInterface1 = TechnologyInterface("Management Interface")
	val bladeSystem2 = Device("Blade System 2")
		.rel.composedOf(managementInterface1)
	val managementInterface2 = TechnologyInterface("Management Interface")
	val bladeSystem1 = Device("Blade System 1")
		.rel.composedOf(managementInterface1)
		.rel.assignedTo(hypervisor)

	val managementInterface3 = TechnologyInterface("Management Interface")
	val dataCenterSwitch = Node("Data Center Switch")
		.rel.composedOf(managementInterface3)

	val dataCenterNetwork = CommunicationNetwork("Data Center Network")
		.rel.associatedWith(bladeSystem1)
		.rel.associatedWith(bladeSystem2)
		.rel.associatedWith(dataCenterSwitch)

	val wideAreaNetwork = CommunicationNetwork("Wide Area Network")
		.rel.associatedWith(dataCenterSwitch)

	val dataReplicationPath = Path("Data Replication Path")
		.rel.junction.and(dataCenterNetwork, wideAreaNetwork).realizesThis()

	render(
		PlantUml.opt
			.title("Example 29. Technology Active Structure Elements (Technology)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap10.html#_Toc489946091]]")
			.get,
		eCommerceHosting
	)

}
