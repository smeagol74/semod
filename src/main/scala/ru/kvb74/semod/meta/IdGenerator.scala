package ru.kvb74.semod.meta

import scala.collection.mutable

object IdGenerator {

  private val _ids = mutable.HashMap.empty[String, Long]

  private val _key = mutable.HashMap.empty[String, String]
  private val _prefix = mutable.HashMap.empty[String, String]

  def next(key: String): String = {
    val _id = _ids.getOrElse(key, 0L) + 1L
    _ids.put(key, _id)
    val prefix = _prefix.getOrElse(key, key)
    s"${prefix}_${_id}"
  }

  def registerPrefix(key: String, prefix: String): Unit = {
    _key.get(prefix) match {
      case Some(_k) =>
        if (_k != key) {
          assert(assertion = false, s"Prefix '$prefix' is already registered for key '${_k}' also wants to register this for key '$key'")
        }
      case None =>
        _key.put(prefix, key)
        _prefix.put(key, prefix)
    }
  }
}
