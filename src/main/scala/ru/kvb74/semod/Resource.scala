package ru.kvb74.semod

import java.util.ResourceBundle

import ru.kvb74.utils.CombinedResourceBundle
import collection.JavaConverters._

object Resource {

  private def _bundle(bundles: Seq[String], raiseErrors: Boolean): ResourceBundle = {
    val result = new CombinedResourceBundle(bundles.asJava)
    result.load(raiseErrors)
    result
  }

  def bundle: ResourceBundle = _bundle(Seq(
    "relationships",
    "system",
    "archimate",
    "essence"
  ), raiseErrors = true)

  def bundle(theme: String): ResourceBundle = _bundle(Seq(
    "relationships",
    "system",
    "archimate",
    "essence",
    s"relationships_$theme",
    s"system_$theme",
    s"archimate_$theme",
    s"essence_$theme",
  ), raiseErrors = false)

}
