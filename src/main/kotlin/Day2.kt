package me.toddbensmiller.advent

import java.util.Collections.min

fun day2(): Pair<Number,Number>
{
	return Pair(day2part1(ListHolder.day2),day2part2(ListHolder.day2))
}

fun day2part1(input: List<String>): Number
{
	var totalPaper = 0
	val parsed = input.map { a -> a.split('x').map { b -> b.toInt()}}
	for(line in parsed)
	{
		val sideA = line[0]*line[1]
		val sideB = line[0]*line[2]
		val sideC = line[1]*line[2]
		val smallSide = min(setOf(sideA, sideB, sideC))
		totalPaper += 2*sideA + 2*sideB + 2*sideC + smallSide
	}
	return totalPaper
}
fun day2part2(input: List<String>): Number
{
	var totalRibbon = 0
	val parsed = input.map { a -> a.split('x').map { b -> b.toInt()}}
	for(line in parsed)
	{
		val lenA = line[0]
		val lenB = line[1]
		val lenC = line[2]
		val sides = listOf(lenA,lenB,lenC).sorted()
		val ribbonLength = 2*sides[0] + 2*sides[1] + lenA*lenB*lenC
		totalRibbon += ribbonLength
	}
	return totalRibbon
}
