package ru.kvb74.semod

import org.scalatest.FunSuite
import ru.kvb74.semod.opengroup.archimate.business.BusinessActor
import ru.kvb74.semod.opengroup.archimate.technology.TechnologyEvent
import ru.kvb74.semod.system.meta.layer.SystemLayer
import ru.kvb74.semod.system.system.{SystemOther, SystemOur}

class DBTest extends FunSuite {

	test("testByLayer") {
		val s1 = SystemOur("Our")
		val s2 = SystemOther("Other")
		val b1 = BusinessActor("Actor")
		val t1 = TechnologyEvent("Event")

		val test = DB.query.all
			.layer(SystemLayer)
			.get
		assert(test.contains(s1))
		assert(test.contains(s2))
		assert(!test.contains(b1))
		assert(!test.contains(t1))
	}

}
