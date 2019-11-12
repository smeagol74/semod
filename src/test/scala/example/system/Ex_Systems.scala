package example.system

import ru.kvb74.semod.plantuml.PlantUml
import ru.kvb74.semod.system.system.{Placeholder, SystemOfInterest, SystemOther, SystemOur, SystemRole}

case object Ex_Systems extends App with SystemExample {

  val top = SystemOther("Owning System")
  val soi = SystemOfInterest("System of Interest")
  val placeholder = Placeholder("System Type")
  val role = SystemRole("Performer")
  val our = SystemOur("Our System")
  val concurrent = SystemOther("Concurrent System")

  top
    .rel.composedOf(soi)
  soi
    .rel.composedOf(placeholder)
    .rel.composedOf(role)
  our
    .rel.realizes(placeholder)
  concurrent
    .rel.realizes(placeholder)

  render(
    PlantUml.opt
      .title("Example. Systems")
      .get,
    top
  )

}
