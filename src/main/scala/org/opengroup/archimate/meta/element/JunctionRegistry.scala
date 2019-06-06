package org.opengroup.archimate.meta.element

import org.opengroup.archimate.meta.relationship.Relationship
import org.opengroup.archimate.relationship.dependency.{Access, Influence, Serving}
import org.opengroup.archimate.relationship.dynamic.{Flow, Triggering}
import org.opengroup.archimate.relationship.other.{Association, Specialization}
import org.opengroup.archimate.relationship.structural.{Aggregation, Assignment, Composition, Realization}

import scala.collection.mutable

object Method extends Enumeration {
	val
	accesses,
	influences,
	serves,
	flowsTo,
	triggers,
	associatedWith,
	specializationOf,
	aggregates,
	assignedTo,
	composedOf,
	realizes = Value
}

trait JunctionRegistry {

	private val _traits = mutable.Map.empty[String, mutable.Set[String]]
	private val _methods = mutable.Map.empty[String, mutable.Map[Method.Value, mutable.Set[String]]]

	/**
		* @param src trait element name
		* @param dst final implementing element name
		*/
	private def _appendTraits(src: String, dst: String): Unit = {
		val _classes = _traits.getOrElseUpdate(src, mutable.Set.empty[String])
		_classes.add(dst)
	}

	/**
		* @param src  final element name
		* @param data methods with destination traits
		*/
	private def _appendMethods(src: String, data: mutable.Map[Method.Value, mutable.Set[String]]): Unit = {
		val _data = _methods.getOrElseUpdate(src, mutable.Map.empty[Method.Value, mutable.Set[String]])
		for ((method, traits) <- data) {
			val _traits = _data.getOrElseUpdate(method, mutable.Set.empty[String])
			traits.foreach(_traits.add)
		}
	}

	/**
		* @param elementTrait    trait element name
		* @param elementInstance final implementing case class element name
		* @param data            methods with destination traits
		*/
	def append(elementTrait: ElementName, elementInstance: Element, data: (Method.Value, ElementName)*): Unit = {
		_appendTraits(elementTrait.name, elementInstance.elementName)
		val map = mutable.Map.empty[Method.Value, mutable.Set[String]]
		for (row <- data) {
			val m = map.getOrElseUpdate(row._1, mutable.Set.empty[String])
			m.add(row._2.name)
		}
		_appendMethods(elementInstance.elementName, map)
	}

	def assertRelationAllowed(method: Method.Value, src: Element, dst: Element): Unit = {

		def _doAssert(message: String): Unit = assert(assertion = false, s"Отношение '$src' -$method-> '$dst' недопустимо в archimate. $message")

		_methods.get(src.elementName) match {
			case Some(methods) =>
				methods.get(method) match {
					case Some(traits) =>
						var notFound = true
						for (t <- traits) {
							notFound = notFound && !_traits.getOrElse(t, mutable.Set.empty[String]).contains(dst.elementName)
						}
						if (notFound) {
							_doAssert(s"У элемента `${src.elementName}` нет зарегистрированного отношения `$method` с элементом `${dst.elementName}`.")
						}
					case None =>
						_doAssert(s"У элемента `${src.elementName}` нет зарегистрированного отношения `$method`.")
				}
			case None =>
				_doAssert(s"Нет зарегистрированных отношений для элемента `${src.elementName}`.")
		}
	}

	def assertRelationAllowed(rel: Relationship): Unit = {
		val method = rel match {
			case _: Access => Method.accesses
			case _: Influence => Method.influences
			case _: Serving => Method.serves
			case _: Flow => Method.flowsTo
			case _: Triggering => Method.triggers
			case _: Association => Method.associatedWith
			case _: Specialization => Method.specializationOf
			case _: Aggregation => Method.aggregates
			case _: Assignment => Method.assignedTo
			case _: Composition => Method.composedOf
			case _: Realization => Method.realizes
		}

		val src = if (rel.direct) rel.src else rel.dst
		val dst = if (rel.direct) rel.dst else rel.src

		assertRelationAllowed(method, src, dst)
	}

	def accesses(tName: ElementName): (Method.Value, ElementName) = Method.accesses -> tName

	def influences(tName: ElementName): (Method.Value, ElementName) = Method.influences -> tName

	def serves(tName: ElementName): (Method.Value, ElementName) = Method.serves -> tName

	def flowsTo(tName: ElementName): (Method.Value, ElementName) = Method.flowsTo -> tName

	def triggers(tName: ElementName): (Method.Value, ElementName) = Method.triggers -> tName

	def associatedWith(tName: ElementName): (Method.Value, ElementName) = Method.associatedWith -> tName

	def specializationOf(tName: ElementName): (Method.Value, ElementName) = Method.specializationOf -> tName

	def aggregates(tName: ElementName): (Method.Value, ElementName) = Method.aggregates -> tName

	def assignedTo(tName: ElementName): (Method.Value, ElementName) = Method.assignedTo -> tName

	def composedOf(tName: ElementName): (Method.Value, ElementName) = Method.composedOf -> tName

	def realizes(tName: ElementName): (Method.Value, ElementName) = Method.realizes -> tName

}

object JR
	extends JunctionRegistry