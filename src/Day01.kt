import kotlin.math.abs

fun parseInput(input: List<String>): Pair<List<Int>, List<Int>> {
    return input.foldRight(Pair(mutableListOf<Int>(), mutableListOf<Int>())) { s, acc ->
        val (first, second) = s.split("   ")
        acc.first.add(first.toInt())
        acc.second.add(second.toInt())
        acc
    }
}

fun part1(input: Pair<List<Int>, List<Int>>): Int {
    return input.first.sorted().zip(input.second.sorted()).sumOf { xs -> abs(xs.first - xs.second) }
}

fun part2(input: Pair<List<Int>, List<Int>>): Int {
    return input.first.sumOf { e -> e * input.second.count { f -> e == f } }
}


fun main() {
    val input = parseInput(readInput("Day01"))
    part1(input).println()
    part2(input).println()
}