package ru.kvb74.semod

import ru.kvb74.semod.meta.{Element, ElementProps, Layer}

import scala.collection.mutable

object DB {
	val _elements = mutable.Set.empty[Element]

	def register(element: Element): Unit = _elements.add(element)

	def byLayer(layer: Layer): Set[Element] = _elements.filter(e => e match {
		case l: Layer =>
			l.layerName.equalsIgnoreCase(layer.layerName)
		case _ =>
			false
	}).toSet

	def byAllTags(tags: String*): Set[Element] = {
		val tSet = tags.map(_.toLowerCase).toSet
		_elements
			.filter(e => tSet.subsetOf(
				e.props
					.asStringSet(ElementProps.tags)
					.getOrElse(Set())
			))
			.toSet
	}

	def byAnyTags(tags: String*): Set[Element] = {
		val tSet = tags.map(_.toLowerCase).toSet
		_elements
			.filter(e => {
				val eTags = e.props.asStringSet(ElementProps.tags).getOrElse(Set())
				tSet.exists(eTags.contains)
			})
			.toSet
	}

	def withAllRelations(elements: Element*): Set[Element] = elements.flatMap(e => {
		e.relatedElements + e
	}).toSet

	def withRelationsOfType(clazz: Class[_], elements: Element*): Set[Element] = elements.flatMap(e => {
		e.relatedElements
			.filter(re =>
				clazz.isAssignableFrom(re.getClass)
			) + e
	}).toSet

	def withRelationsOfTypeRecursive(clazz: Class[_], elements: Element*): Set[Element] = elements.flatMap(e => {
		val childs = e.relatedElements
			.filter(re =>
				!elements.contains(re) && clazz.isAssignableFrom(re.getClass)
			)
		if (childs.nonEmpty) {
			val childsRecursive = withRelationsOfTypeRecursive(clazz, (childs ++ elements).toSeq: _*)
			if (childsRecursive.size > childs.size) {
				childsRecursive + e
			} else {
				childs + e
			}
		} else {
			childs + e
		}
	}).toSet
}
