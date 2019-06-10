package example._11_physical

import example.Example
import ru.kvb74.semod.opengroup.archimate.physical.{DistributionNetwork, Equipment, Facility, Material}
import ru.kvb74.semod.opengroup.archimate.relationship.dependency.AccessMode
import ru.kvb74.semod.opengroup.archimate.technology.Path
import ru.kvb74.semod.plantuml.PlantUml

/**
	* @see http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946113
	*/
case object Ex_32_PhysicalElements extends App with Example {

	val preAssembledCircuitBoard = Material("Pre-Assembled Circuit Board")
	val internalAntenna = Material("Internal Antenna")
	val plasticCase = Material("Plastic Case")
	val vehicleTelematicsAppliance = Material("Vehicle Telematics Appliance")

	val assemblyLine = Equipment("Assembly Line")
		.rel.accesses(preAssembledCircuitBoard, AccessMode.READ)
		.rel.accesses(internalAntenna, AccessMode.READ)
		.rel.accesses(plasticCase, AccessMode.READ)
		.rel.accesses(vehicleTelematicsAppliance, AccessMode.WRITE)

	val localDistributionCenter = Facility("Local Distrubution Center")
		.rel.accesses(vehicleTelematicsAppliance, AccessMode.READ)
	val nationalDistributionCenter = Facility("National Distrubution Center")
		.rel.accesses(vehicleTelematicsAppliance, AccessMode.READ)
	val localTrucking = DistributionNetwork("Local Tracking")
		.rel.associatedWith(localDistributionCenter)
		.rel.associatedWith(nationalDistributionCenter)

	val manufacturingPlant = Facility("Manufacturing Plant")
		.rel.assignedTo(assemblyLine)
		.rel.accesses(vehicleTelematicsAppliance, AccessMode.WRITE)

	val overseasShipping = DistributionNetwork("Overseas Shipping")
		.rel.associatedWith(nationalDistributionCenter)
		.rel.associatedWith(manufacturingPlant)

	val intermodalFreight = Path("Intermodal Freight")
		.rel.junction.and(localTrucking, overseasShipping).realizesThis

	render(
		PlantUml.opt
			.title("Example 32. Physical Elements (Physical)")
			.footer("[[http://pubs.opengroup.org/architecture/archimate3-doc/chap11.html#_Toc489946113]]")
			.get,
		intermodalFreight
	)

}
