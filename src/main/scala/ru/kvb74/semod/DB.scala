package ru.kvb74.semod

import ru.kvb74.semod.meta.{Element, ElementProps, Layer}

import scala.collection.mutable

class DBQuery(var _elements: Set[Element]) {

	def get: Set[Element] = _elements

	def layer(layer: Layer): DBQuery = {
		_elements = _elements.filter(e => e match {
			case l: Layer =>
				l.layerName.equalsIgnoreCase(layer.layerName)
			case _ =>
				false
		})
		this
	}

	def classOf(clazz: Class[_]): DBQuery = {
		_elements = _elements.filter(e => clazz.isAssignableFrom(e.getClass))
		this
	}

	def allTags(tags: String*): DBQuery = {
		val tSet = tags.map(_.toLowerCase).toSet
		_elements = _elements
			.filter(e => tSet.subsetOf(
				e.props
					.asStringSet(ElementProps.tags)
					.getOrElse(Set())
			))
		this
	}

	def anyTags(tags: String*): DBQuery = {
		val tSet = tags.map(_.toLowerCase).toSet
		_elements = _elements
			.filter(e => {
				val eTags = e.props.asStringSet(ElementProps.tags).getOrElse(Set())
				tSet.exists(eTags.contains)
			})
		this
	}

	def relations: DBQuery = {
		_elements = _elements.flatMap(e => {
			e.relatedElements + e
		})
		this
	}

	def relationsOfType(clazz: Class[_]): DBQuery = {
		_elements = _elements.flatMap(e => {
			e.relatedElements
				.filter(re =>
					clazz.isAssignableFrom(re.getClass)
				) + e
		})
		this
	}

	@scala.annotation.tailrec
	private def _withRelationsOfTypeRecursive(clazz: Class[_],
		elements: Set[Element]): Set[Element] = {
		val res = mutable.HashSet.empty[Element]
		res ++= elements

		elements.foreach(el => res ++= el.relatedElements
			.filter(re =>
				!elements.contains(re) && clazz.isAssignableFrom(re.getClass)
			))

		if (res.size != elements.size)
			_withRelationsOfTypeRecursive(clazz, res.toSet)
		else
			res.toSet
	}

	def relationsOfTypeRecursive(clazz: Class[_]): DBQuery = {
		_elements = _withRelationsOfTypeRecursive(clazz, _elements)
		this
	}

	@scala.annotation.tailrec
	private def _withRelationsRecursive(elements: Set[Element]): Set[Element] = {
		val res = mutable.HashSet.empty[Element]
		res ++= elements

		elements.foreach(el => res ++= el.relatedElements)

		if (res.size != elements.size)
			_withRelationsRecursive(res.toSet)
		else
			res.toSet
	}


	def relationsRecursive: DBQuery = {
		_elements = _withRelationsRecursive(_elements)
		this
	}

}

object DB {
	val _elements = mutable.Set.empty[Element]

	def register(element: Element): Unit = _elements.add(element)

	object query {
		def all: DBQuery = new DBQuery(_elements.toSet)

		def forElements(elements: Element*): DBQuery = new DBQuery(elements.toSet)

		def forElements(elements: Set[Element]): DBQuery = new DBQuery(elements)
	}

}
