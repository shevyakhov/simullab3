package com.chelz.simullab3

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chelz.simullab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var rules: Rules
	private lateinit var binding: ActivityMainBinding
	private var table = ArrayList<ArrayList<ImageView>>()
	private var tableInt = ArrayList<ArrayList<Int>>()
	private var row0 = ArrayList<ImageView>()
	private var row1 = ArrayList<ImageView>()
	private var row2 = ArrayList<ImageView>()
	private var row3 = ArrayList<ImageView>()
	private var row4 = ArrayList<ImageView>()
	private var row5 = ArrayList<ImageView>()
	private var row6 = ArrayList<ImageView>()
	private var row7 = ArrayList<ImageView>()
	private var gen = 0
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initRows()
		initRow0Listeners()
		clearTable()
		binding.btnNext.setOnClickListener {
			generateNext()
		}
		binding.btnClear.setOnClickListener {
			clearRows()
			gen = 0
			clearTable()

		}
		binding.btnApply.setOnClickListener {
			initRules()
			clearRows()
			gen = 0
			clearTable()
		}
	}

	private fun generateNext() {
		gen++
		gen = gen.mod(8)

		for (self in tableInt[gen].indices) {
			tableInt[gen][self] = rules.retrieveValue(
				tableInt[(8 + (gen - 1)).mod(8)][(8 + (self - 1)).mod(8)],
				tableInt[(8 + (gen - 1)).mod(8)][self],
				tableInt[(8 + (gen - 1)).mod(8)][(self + 1).mod(8)]
			)
			render(gen, self, tableInt[gen][self])
		}
		clearRow((gen + 2).mod(8))
		println(tableInt)
	}

	private fun render(gen: Int, index: Int, value: Int) {
		if (value == 1) {
			table[gen][index].setImageResource(R.color.black)
		} else
			table[gen][index].setImageResource(R.color.white)

	}

	private fun clearRow(row: Int) {
		for (i in table[row].indices) {
			tableInt[row][i] = 0
			render(row, i, 0)
		}
	}

	private fun initRow0Listeners() {
		for (i in row0.indices) {
			row0[i].setOnClickListener {
				if (tableInt[0][i] == 1) {
					row0[i].setImageResource(R.color.white)
					tableInt[0][i] = 0
				} else {
					row0[i].setImageResource(R.color.black)
					tableInt[0][i] = 1
				}
			}
		}

	}

	private fun initRules() {
		if (binding.edRule.text?.isNotEmpty() == true) {
			if (binding.edRule.text.toString().toInt() in 0..255) {
				rules = Rules(binding.edRule.text.toString().toInt())
			} else Toast.makeText(this, "rule in range 0..255", Toast.LENGTH_SHORT).show()
		}
	}

	private fun clearTable() {
		for (row in tableInt) {
			row.clear()
		}
		tableInt.clear()
		for (i in 0..7) {
			val row = arrayListOf(0, 0, 0, 0, 0, 0, 0, 0)
			tableInt.add(row)
		}
	}

	private fun clearRows() {
		for (row in table) {
			for (item in row) {
				item.setImageResource(R.color.white)
			}
		}
	}

	private fun initRows() {
		initRow0()
		initRow1()
		initRow2()
		initRow3()
		initRow4()
		initRow5()
		initRow6()
		initRow7()
		initTable()
	}

	private fun initTable() {
		table.add(row0)
		table.add(row1)
		table.add(row2)
		table.add(row3)
		table.add(row4)
		table.add(row5)
		table.add(row6)
		table.add(row7)
	}

	private fun initRow0() {
		row0.add(binding.t00)
		row0.add(binding.t01)
		row0.add(binding.t02)
		row0.add(binding.t03)
		row0.add(binding.t04)
		row0.add(binding.t05)
		row0.add(binding.t06)
		row0.add(binding.t07)
	}

	private fun initRow1() {
		row1.add(binding.t10)
		row1.add(binding.t11)
		row1.add(binding.t12)
		row1.add(binding.t13)
		row1.add(binding.t14)
		row1.add(binding.t15)
		row1.add(binding.t16)
		row1.add(binding.t17)
	}

	private fun initRow2() {
		row2.add(binding.t20)
		row2.add(binding.t21)
		row2.add(binding.t22)
		row2.add(binding.t23)
		row2.add(binding.t24)
		row2.add(binding.t25)
		row2.add(binding.t26)
		row2.add(binding.t27)
	}

	private fun initRow3() {
		row3.add(binding.t30)
		row3.add(binding.t31)
		row3.add(binding.t32)
		row3.add(binding.t33)
		row3.add(binding.t34)
		row3.add(binding.t35)
		row3.add(binding.t36)
		row3.add(binding.t37)
	}

	private fun initRow4() {
		row4.add(binding.t40)
		row4.add(binding.t41)
		row4.add(binding.t42)
		row4.add(binding.t43)
		row4.add(binding.t44)
		row4.add(binding.t45)
		row4.add(binding.t46)
		row4.add(binding.t47)
	}

	private fun initRow5() {
		row5.add(binding.t50)
		row5.add(binding.t51)
		row5.add(binding.t52)
		row5.add(binding.t53)
		row5.add(binding.t54)
		row5.add(binding.t55)
		row5.add(binding.t56)
		row5.add(binding.t57)
	}

	private fun initRow6() {
		row6.add(binding.t60)
		row6.add(binding.t61)
		row6.add(binding.t62)
		row6.add(binding.t63)
		row6.add(binding.t64)
		row6.add(binding.t65)
		row6.add(binding.t66)
		row6.add(binding.t67)
	}

	private fun initRow7() {
		row7.add(binding.t70)
		row7.add(binding.t71)
		row7.add(binding.t72)
		row7.add(binding.t73)
		row7.add(binding.t74)
		row7.add(binding.t75)
		row7.add(binding.t76)
		row7.add(binding.t77)
	}
}
