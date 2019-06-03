package org.opengroup.archimate.technology

import org.opengroup.archimate.meta.element.technology.{TechnologyCollaborationElement, TechnologyCollaborationElementRelationships}
import org.opengroup.archimate.meta.layer.Technology

case class TechnologyCollaboration(
	name: String,
	desc: String = ""
) extends Technology
	with TechnologyCollaborationElement {

	object rel extends TechnologyCollaborationElementRelationships[TechnologyCollaboration] {
		private[archimate] implicit val tt: TechnologyCollaboration = TechnologyCollaboration.this
	}

}
