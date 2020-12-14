package me.toddbensmiller.advent

import kotlin.math.max

fun day6(): Pair<Number,Number>
{
	return Pair(day6part1(ListHolder.day6),day6part2(ListHolder.day6))
}

data class PointRange(val x1: Int, val y1: Int, val x2: Int, val y2: Int)
enum class State6 { ON, OFF, TOGGLE}
fun day6part1(input: List<String>): Number
{
	val charList = listOf('0','1','2','3','4','5','6','7','8','9','0',',')
	val splits = input.map {line -> line.replace(" through ",",").filter {it in charList}.split(',') }
	val coords = splits.map { line -> PointRange(line[0].toInt(),line[1].toInt(),line[2].toInt(),line[3].toInt())}
	val states = input.map { line -> when{
		line.contains("toggle") -> State6.TOGGLE
		line.contains("on") -> State6.ON
		line.contains("off") -> State6.OFF
		else -> throw Exception()
	}}
	val grid = Array(1000) { Array(1000) { false } }
	for(i in states.indices)
	{
		for(x in coords[i].x1..coords[i].x2)
		{
			for(y in coords[i].y1..coords[i].y2)
			{
				when(states[i])
				{
					State6.ON -> grid[x][y] = true
					State6.OFF -> grid[x][y] = false
					State6.TOGGLE -> grid[x][y] = !grid[x][y]
				}
			}
		}
	}
	return grid.sumOf { row -> row.count { col -> col } }
}
fun day6part2(input: List<String>): Number
{
	val charList = listOf('0','1','2','3','4','5','6','7','8','9','0',',')
	val splits = input.map {line -> line.replace(" through ",",").filter {it in charList}.split(',') }
	val coords = splits.map { line -> PointRange(line[0].toInt(),line[1].toInt(),line[2].toInt(),line[3].toInt())}
	val states = input.map { line -> when{
		line.contains("toggle") -> State6.TOGGLE
		line.contains("on") -> State6.ON
		line.contains("off") -> State6.OFF
		else -> throw Exception()
	}}
	val grid = Array(1000) { Array(1000) { 0 } }
	for(i in states.indices)
	{
		for(x in coords[i].x1..coords[i].x2)
		{
			for(y in coords[i].y1..coords[i].y2)
			{
				when(states[i])
				{
					State6.ON -> grid[x][y] = grid[x][y] + 1
					State6.OFF -> grid[x][y] = max( grid[x][y] - 1, 0)
					State6.TOGGLE -> grid[x][y] = grid[x][y] + 2
				}
			}
		}
	}
	return grid.sumOf { row -> row.sumOf { it } }
}
