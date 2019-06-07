package ru.kvb74.semod.opengroup.archimate.meta.relationship

import ru.kvb74.semod.opengroup.archimate.meta.element.relationship.{And, Or}
import ru.kvb74.semod.opengroup.archimate.meta.element.{Element, JR, Method}

object JunctionMode extends Enumeration {
	val OR, AND = Value
}

case class JunctionSrc(mode: JunctionMode.Value, src: Element*) {
	def accesses: JunctionMethod = JunctionMethod(this, Method.accesses)

	def influences: JunctionMethod = JunctionMethod(this, Method.influences)

	def serves: JunctionMethod = JunctionMethod(this, Method.serves)

	def flowsTo: JunctionMethod = JunctionMethod(this, Method.flowsTo)

	def triggers: JunctionMethod = JunctionMethod(this, Method.triggers)

	def associatedWith: JunctionMethod = JunctionMethod(this, Method.associatedWith)

	def specializationOf: JunctionMethod = JunctionMethod(this, Method.specializationOf)

	def aggregates: JunctionMethod = JunctionMethod(this, Method.aggregates)

	def assignedTo: JunctionMethod = JunctionMethod(this, Method.assignedTo)

	def composedOf: JunctionMethod = JunctionMethod(this, Method.composedOf)

	def realizes: JunctionMethod = JunctionMethod(this, Method.realizes)
}

case class JunctionMethod(src: JunctionSrc, method: Method.Value) {

	private def _junctionElement(mode: JunctionMode.Value) = mode match {
		case JunctionMode.AND => And()
		case JunctionMode.OR => Or()
	}

	private def _apply[T <: Element](implicit src: T, method: Method.Value, dst: Element): T = src._rel.apply(method, dst)

	private def _junction(mode: JunctionMode.Value, dst: Element*): Unit = {
		val _src = src.src
		val _dst = dst

		for (_s <- _src) {
			for (_d <- _dst) {
				JR.assertRelationAllowed(method, _s, _d)
			}
		}

		if (_src.size == 1 && _dst.size > 1) {
			val j = _junctionElement(mode)
			_apply(_src.head, method, j)
			for (_d <- _dst) {
				_apply(j, method, _d)
			}
		} else if (_src.size > 1 && _dst.size == 1) {
			val j = _junctionElement(src.mode)
			for (_s <- _src) {
				_apply(_s, method, j)
			}
			_apply(j, method, _dst.head)
		} else if (_src.size > 1 && _dst.size > 1) {
			val js = _junctionElement(src.mode)
			val jd = _junctionElement(mode)
			for (_s <- _src) {
				_apply(_s, method, js)
			}
			_apply(js, method, jd)
			for (_d <- _dst) {
				_apply(jd, method, _d)
			}
		} else if (_src.size == 1 && _dst.size == 1) {
			_apply(_src.head, method, _dst.head)
		} else {
			assert(assertion = false, "Source elements or destination elements can not be empty")
		}
	}

	def and(dst: Element*): Unit = _junction(JunctionMode.AND, dst: _*)

	def or(dst: Element*): Unit = _junction(JunctionMode.OR, dst: _*)
}

object Junction {

	def and(src: Element*): JunctionSrc = JunctionSrc(JunctionMode.AND, src: _*)

	def or(src: Element*): JunctionSrc = JunctionSrc(JunctionMode.OR, src: _*)

}