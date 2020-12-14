package me.toddbensmiller.advent

import java.io.File
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8


fun day4(): Pair<Number, Number>
{
	return Pair(day4part1(ListHolder.day4), day4part2(ListHolder.day4))
}

fun day4part1(input: List<String>): Number
{
	val seed = File("src/main/resources/4seed1.txt").readLines()[0].toInt() // store a 0 in the file
	// unless you have a specific starting value to skip to
	var num = 0
	var unbroken = true
	var count = seed
	while (unbroken)
	{
		(1..10000).toList().parallelStream().forEach { x ->
			if (md5("${input[0]}${x+count}").toHex().startsWith("00000"))
			{
				unbroken = false
				num = x+count
			}
		}
		count += 10000
	}
	return num
}


fun day4part2(input: List<String>): Number
{
	val seed = File("src/main/resources/4seed2.txt").readLines()[0].toInt() // store a 0 in the file
	// unless you have a specific starting value to skip to
	var num = 0
	var unbroken = true
	var count = seed
	while (unbroken)
	{
		(1..10000).toList().parallelStream().forEach { x ->
			if (md5("${input[0]}${x+count}").toHex().startsWith("000000"))
			{
				unbroken = false
				num = x+count
			}
		}
		count += 10000
	}
	return num
}

fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }