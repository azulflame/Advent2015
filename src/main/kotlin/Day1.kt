package me.toddbensmiller.advent

fun day1(): Pair<Number,Number>
{
	return Pair(day1part1(ListHolder.day1),day1part2(ListHolder.day1))
}

fun day1part1(input: List<String>): Number
{
	return input[0].count{ it == '(' } - input[0].count { it == ')'}
}
fun day1part2(input: List<String>): Number
{
	var floor = 0
	for(x in input[0].indices)
	{
		if(floor == -1)
		{
			return x
		}
		if(input[0][x] == ')')
		{
			floor--
		}
		if(input[0][x] == '(')
		{
			floor++
		}
	}
	return 0
}
