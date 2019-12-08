package example.ontology

import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.ontology.ontology._

case object Ex_Ontology extends App with OntologyExample {

  val e1 = Concept("Понятие 1").rel.associatedWith(e2, "следует из >")
  lazy val e2 = Concept("Понятие 2")

  render(
    PlantUml.opt
      .title("Example. Ontology")
      .get,
    e1, e2
  )

}
