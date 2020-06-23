package docs.ru.ontology

import ru.kvb74.semod.ontology.ontology.Concept
import ru.kvb74.semod.plantuml.PlantUml

case object Overview extends App with OntologyExample {

	val systemThinking = Concept("Системное мышление")
		.rel.specializationOf(thinking)
		.rel.__(complex, "упрощает")
	lazy val thinking = Concept("Мышление")
	lazy val complex = Concept("Сложный проект")
	val work = Concept("Работа")
		.rel.__(complex, "продвигает")

	render(
		PlantUml.opt
			.title("Онтика")
			.get
	)

}
