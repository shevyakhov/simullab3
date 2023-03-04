package com.chelz.simullab3

data class Rules(private val rule: Int) {

	private val keys = listOf<String>("111", "110", "101", "100", "011", "010", "001", "000")
	fun retrieveValue(left: Int, self: Int, right: Int): Int {
		val key = listOf(left, self, right).joinToString("")
		return binaryRules[keys.indexOf(key)]
	}

	//todo 8 digits
	private val binaryRules: List<Int> = rule.toUInt()
		.toString(radix = 2).padStart(8, '0').split("").filter { it != "" }.map { it.toInt() }

	init {
		println(binaryRules)
	}
}
