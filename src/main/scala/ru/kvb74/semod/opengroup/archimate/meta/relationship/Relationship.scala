package ru.kvb74.semod.opengroup.archimate.meta.relationship

import ru.kvb74.semod.opengroup.archimate.IdGenerator
import ru.kvb74.semod.opengroup.archimate.meta.element.Element

trait Relationship {
	val id: String = IdGenerator.next(this match {
		case product: Product => s"Rel_${product.productPrefix}"
		case _ => "Rel"
	})
	val src: Element
	val dst: Element

	override def equals(obj: Any): Boolean = {
		obj match {
			case rel: Relationship =>
				id.equals(rel.id)
			case _ =>
				super.equals(obj)
		}
	}

}
