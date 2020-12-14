package me.toddbensmiller.advent

import java.io.File

fun main(args: Array<String>)
{
	runAll()
}

fun runAll()
{
	return listOf(
		day1(),
		day2(),
		day3()
	).forEachIndexed { i, x ->
		println("Day ${i+1}:")
		println("\tPart 1: ${x.first}")
		println("\tPart 2: ${x.second}")
	}
}

fun generate()
{
	for (x in 1..25)
	{
		File("src/main/kotlin/Day${x}.kt").printWriter().use { pw ->
			pw.println(
				"""package me.toddbensmiller.advent

fun day${x}(): Pair<Number,Number>
{
	return Pair(day${x}part1(ListHolder.day${x}),day${x}part2(ListHolder.day${x}))
}

fun day${x}part1(input: List<String>): Number
{
	return 0
}
fun day${x}part2(input: List<String>): Number
{
	return 0
}"""
			)
		}
		File("src/main/resources/day${x}.txt").printWriter().use { pw ->
			pw.print("""""")
		}
	}
}