package org.opengroup.archimate

import scala.collection.mutable

object IdGenerator {

	private val _ids = mutable.HashMap.empty[String, Long]

	private def _next(key: String, prefix: String): String = {
		val _id = _ids.getOrElse(key, 0L) + 1L
		_ids.put(key, _id)
		s"${prefix}_${_id}"
	}

	object motivation {
		def assessment: String = _next("motivation.assessment", "MA")

		def constraint: String = _next("motivation.constraint", "MC")

		def driver: String = _next("motivation.driver", "MD")

		def goal: String = _next("motivation.goal", "MG")

		def meaning: String = _next("motivation.meaning", "MM")

		def outcome: String = _next("motivation.outcome", "MO")

		def principle: String = _next("motivation.principle", "MP")

		def requirement: String = _next("motivation.requirement", "MR")

		def stakeholder: String = _next("motivation.stakeholder", "MS")

		def value: String = _next("motivation.value", "MV")
	}

	object strategy {
		def capability: String = _next("strategy.capability", "SC")

		def courseOfAction: String = _next("strategy.courseOfAction", "SCOA")

		def resource: String = _next("strategy.resource", "SR")
	}

	object physical {
		def material: String = _next("physical.material", "PM")

		def facility: String = _next("physical.facility", "PF")

		def equipment: String = _next("physical.equipment", "PE")

		def distributionNetwork: String = _next("physical.distributionNetwork", "PDN")

	}

	object technology {
		def technologyObject: String = _next("technology.technologyObject", "TO")

		def artifact: String = _next("technology.artifact", "TA")

		def technologyInterface: String = _next("technology.technologyInterface", "TIf")

		def technologyCollaboration: String = _next("technology.technologyCollaboration", "TC")

		def systemSoftware: String = _next("technology.systemSoftware", "TSS")

		def path: String = _next("technology.path", "TPa")

		def node: String = _next("technology.node", "TN")

		def device: String = _next("technology.device", "TD")

		def communicationNetwork: String = _next("technology.communicationNetwork", "TCN")

		def technologyService: String = _next("technology.technologyService", "TS")

		def technologyProcess: String = _next("technology.technologyProcess", "TP")

		def technologyInteraction: String = _next("technology.technologyInteraction", "TI")

		def technologyFunction: String = _next("technology.technologyFunction", "TF")

		def technologyEvent: String = _next("technology.technologyEvent", "TE")

	}

	object relationships {

	}

	object application {
		def dataObject: String = _next("application.dataObject", "ADO")

		def applicationInterface: String = _next("application.applicationInterface", "AIf")

		def applicationComponent: String = _next("application.applicationComponent", "ACmp")

		def applicationCollaboration: String = _next("application.applicationCollaboration", "AC")

		def applicationService: String = _next("application.applicationService", "AS")

		def applicationProcess: String = _next("application.applicationProcess", "AP")

		def applicationInteraction: String = _next("application.applicationInteraction", "AI")

		def applicationFunction: String = _next("application.applicationFunction", "AF")

		def applicationEvent: String = _next("application.applicationEvent", "AE")

	}

	object business {
		def contract: String = _next("business.contract", "BCn")

		def businessObject: String = _next("business.businessObject", "BO")

		def businessRole: String = _next("business.businessRole", "BR")

		def businessInterface: String = _next("business.businessInterface", "BIf")

		def businessCollaboration: String = _next("business.businessCollaboration", "BC")

		def businessActor: String = _next("business.businessActor", "BA")

		def product: String = _next("business.product", "BPr")

		def businessProcess: String = _next("business.businessProcess", "BP")

		def businessInteraction: String = _next("business.businessInteraction", "BI")

		def businessFunction: String = _next("business.businessFunction", "BF")

		def businessEvent: String = _next("business.businessEvent", "BE")

		def businessService: String = _next("business.businessService", "BS")

		def representation: String = _next("business.representation", "BRep")

	}

	object implementation {
		def workPackage: String = _next("implementation.workPackage", "IWP")

		def plateau: String = _next("implementation.plateau", "IP")

		def implementationEvent: String = _next("implementation.implementationEvent", "IE")

		def gap: String = _next("implementation.gap", "IG")

		def deliverable: String = _next("implementation.deliverable", "ID")

	}


}
