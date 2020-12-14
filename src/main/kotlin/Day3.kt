package me.toddbensmiller.advent

fun day3(): Pair<Number,Number>
{
	return Pair(day3part1(ListHolder.day3),day3part2(ListHolder.day3))
}

fun day3part1(input: List<String>): Number
{
	val visitedHouses: HashSet<Pair<Int,Int>> = HashSet()
	var x = 0
	var y = 0
	for(move in input[0])
	{
		when(move)
		{
			'v' -> y--
			'^' -> y++
			'<' -> x--
			'>' -> x++
		}
		visitedHouses.add(Pair(x,y))
	}
	return visitedHouses.size
}
fun day3part2(input: List<String>): Number
{
	val visitedHouses: HashSet<Pair<Int, Int>> = HashSet()
	val santaTape = input[0].filterIndexed { i, _ -> i % 2 == 0 }
	val roboTape = input[0].filterIndexed { i, _ -> i % 2 == 1 }
	for (tape in listOf(santaTape, roboTape))
	{
		var x = 0
		var y = 0
		for (move in tape)
		{
			when (move)
			{
				'v' -> y--
				'^' -> y++
				'<' -> x--
				'>' -> x++
			}
			visitedHouses.add(Pair(x, y))
		}
	}
	return visitedHouses.size
}
