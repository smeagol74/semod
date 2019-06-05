package org.opengroup.archimate.meta.relationship

object Junction extends Enumeration {
	/**
		* No Junction, just direct relationship
		*/
	val NONE,

	/**
		* Single in multiple out AND junction
		*/
	AND,

	/**
		* Single in multiple out OR junction
		*/
	OR,

	/**
		* Multiple in single out AND junction
		*/
	IN_AND,

	/**
		* Multiple in single out OR junction
		*/
	IN_OR = Value
}
