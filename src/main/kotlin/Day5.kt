package me.toddbensmiller.advent

fun day5(): Pair<Number,Number>
{
	return Pair(day5part1(ListHolder.day5),day5part2(ListHolder.day5))
}

fun day5part1(input: List<String>): Number
{
	return input.filter { line ->
		line.count { vowels -> vowels in setOf('a','e','i','o','u')} >= 3 &&
		line.filterIndexed { i,x -> i+1 < line.length && x == line[i+1]}.count() >0 &&
		!line.contains("ab") && !line.contains("cd") && !line.contains("pq") && !line.contains("xy")
	}.count()
}
fun day5part2(input: List<String>): Number
{
	return input.filter { line ->
		line.filterIndexed { i,x -> i+2 < line.length && x == line[i+2]}.count() > 0 &&
		line.filterIndexed { i,x -> i+1 < line.length && line.filterIndexed { i2,y ->i2 != i+1 && i2 != i-1 && i2+1 < line.length &&
				"${y}${line[i2+1]}" == "${x}${line[i+1]}"}.count() > 1}.count() > 0
	}.count()
}
