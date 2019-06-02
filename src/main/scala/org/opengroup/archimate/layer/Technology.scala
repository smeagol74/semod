package org.opengroup.archimate.layer

import org.opengroup.archimate.element.{Element, ElementRelationships}
import org.opengroup.archimate.technology.behavior.{TechnologyEvent, TechnologyService}
import org.opengroup.archimate.technology.structure.active.Path
import org.opengroup.archimate.technology.structure.passive.Artifact

trait Technology extends Layer {
	override def _puml = "Technology"
}

trait TechnologyInternalBehaviorElement extends Element

trait TechnologyInternalBehaviorElementRelationships[T <: TechnologyInternalBehaviorElement] extends ElementRelationships[T] {
	def realizes(dst: TechnologyService): T = tt._rel.aggregates(dst)
	def aggregates(dst: TechnologyInternalBehaviorElement): T = tt._rel.aggregates(dst)
	def isComposedOf(dst: TechnologyInternalBehaviorElement): T = tt._rel.isComposedOf(dst)
	def accesses(dst: TechnologyObjectElement): T = tt._rel.accesses(dst)
	def triggers(dst: TechnologyInternalBehaviorElement): T = tt._rel.triggers(dst)
	def flowsTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.flowsTo(dst)
	def triggers(dst: TechnologyEvent): T = tt._rel.triggers(dst)
	def flowsTo(dst: TechnologyEvent): T = tt._rel.flowsTo(dst)
}

trait TechnologyObjectElement extends Element

trait TechnologyObjectElementRelationships[T <: TechnologyObjectElement] extends ElementRelationships[T]

trait TechnologyNodeElement extends Element

trait TechnologyNodeElementRelationships[T <: TechnologyNodeElement] extends ElementRelationships[T] {
	def realizes(dst: TechnologyNodeElement): T = tt._rel.realizes(dst)
	def assignedTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.assignedTo(dst)
	def assignedTo(dst: TechnologyEvent): T = tt._rel.assignedTo(dst)
	def assignedTo(dst: Artifact): T = tt._rel.assignedTo(dst)
	def associatedWith(dst: Path): T = tt._rel.associatedWith(dst)
}
