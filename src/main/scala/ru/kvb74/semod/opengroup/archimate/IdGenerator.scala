package ru.kvb74.semod.opengroup.archimate

import scala.collection.mutable

object IdGenerator {

	private val _ids = mutable.HashMap.empty[String, Long]

	private val _prefix = Map(
		"Motivation_Assessment" -> "MA",
		"Motivation_Constraint" -> "MC",
		"Motivation_Driver" -> "MD",
		"Motivation_Goal" -> "MG",
		"Motivation_Meaning" -> "MM",
		"Motivation_Outcome" -> "MO",
		"Motivation_Principle" -> "MP",
		"Motivation_Requirement" -> "MR",
		"Motivation_Stakeholder" -> "MS",
		"Motivation_Value" -> "MV",
		"Strategy_Capability" -> "SC",
		"Strategy_CourseOfAction" -> "SCOA",
		"Strategy_Resource" -> "SR",
		"Physical_Material" -> "PM",
		"Physical_Facility" -> "PF",
		"Physical_Equipment" -> "PE",
		"Physical_DistributionNetwork" -> "PDN",
		"Technology_TechnologyObject" -> "TO",
		"Technology_Artifact" -> "TA",
		"Technology_TechnologyInterface" -> "TIf",
		"Technology_TechnologyCollaboration" -> "TC",
		"Technology_SystemSoftware" -> "TSS",
		"Technology_Path" -> "TPa",
		"Technology_Node" -> "TN",
		"Technology_Device" -> "TD",
		"Technology_CommunicationNetwork" -> "TCN",
		"Technology_TechnologyService" -> "TS",
		"Technology_TechnologyProcess" -> "TP",
		"Technology_TechnologyInteraction" -> "TI",
		"Technology_TechnologyFunction" -> "TF",
		"Technology_TechnologyEvent" -> "TE",
		"Application_DataObject" -> "ADO",
		"Application_ApplicationInterface" -> "AIf",
		"Application_ApplicationComponent" -> "ACmp",
		"Application_ApplicationCollaboration" -> "AC",
		"Application_ApplicationService" -> "AS",
		"Application_ApplicationProcess" -> "AP",
		"Application_ApplicationInteraction" -> "AI",
		"Application_ApplicationFunction" -> "AF",
		"Application_ApplicationEvent" -> "AE",
		"Business_Contract" -> "BCn",
		"Business_BusinessObject" -> "BO",
		"Business_BusinessRole" -> "BR",
		"Business_BusinessInterface" -> "BIf",
		"Business_BusinessCollaboration" -> "BC",
		"Business_BusinessActor" -> "BA",
		"Business_Product" -> "BPr",
		"Business_BusinessProcess" -> "BP",
		"Business_BusinessInteraction" -> "BI",
		"Business_BusinessFunction" -> "BF",
		"Business_BusinessEvent" -> "BE",
		"Business_BusinessService" -> "BS",
		"Business_Representation" -> "BRep",
		"Implementation_WorkPackage" -> "IWP",
		"Implementation_Plateau" -> "IP",
		"Implementation_ImplementationEvent" -> "IE",
		"Implementation_Gap" -> "IG",
		"Implementation_Deliverable" -> "ID",
		"Junction_And" -> "JA",
		"Junction_Or" -> "JO"
	)

	def next(key: String): String = {
		val _id = _ids.getOrElse(key, 0L) + 1L
		_ids.put(key, _id)
		val prefix = _prefix.getOrElse(key, key)
		s"${prefix}_${_id}"
	}

}
