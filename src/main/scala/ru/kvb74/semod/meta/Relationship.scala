package ru.kvb74.semod.meta

/**
	* Задаёт подсказку в каком направлении следует направлять линию отношения
	*
	* Specifies the rendering hint in what direction should relationship line go
	*/
object DirectionHint extends Enumeration {
	val

	/**
		* Автоматическая раскладка
		*
		* Automatic layout
		*/
	AUTO,

	/**
		* Не применять подсказку
		*
		* Do not apply layout
		*/
	NONE,

	/**
		* Линия отношения должна уходить вверх
		*
		* Relationship line should goes Up
		*/
	UP,

	/**
		* Линия отношения должна уходить вниз
		*
		* Relationship line should goes Down
		*/
	DOWN,

	/**
		* Линия отношения должна уходить влево
		*
		* Relationship line should goes Left
		*/
	LEFT,

	/**
		* Линия отношения должна уходить вправо
		*
		* Relationship line should goes Right
		*/
	RIGHT
	= Value
}

trait Relationship {
	val id: String = IdGenerator.next(this match {
		case product: Product => s"Rel_${product.productPrefix}"
		case _ => "Rel"
	})
	val src: Element
	val dst: Element
	val dir: DirectionHint.Value

	override def equals(obj: Any): Boolean = {
		obj match {
			case rel: Relationship =>
				id.equals(rel.id)
			case _ =>
				super.equals(obj)
		}
	}

	private[semod] def _registerPrefix(prefix: String): Unit = {
		IdGenerator.registerPrefix(this match {
			case product: Product => s"Rel_${product.productPrefix}"
			case _ => "Rel"
		}, prefix)
	}

}
