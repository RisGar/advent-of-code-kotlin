fun parse(input: List<String>): List<List<Int>> {
  return input.map { it.split(" ").map { it.toInt() } }
}


fun isValidSequence(input: List<Int>): Boolean {
  val direction = input.zipWithNext().first().let { (x, y) -> if (x < y) 1 else -1 }
  return input.zipWithNext().all { (x, y) -> direction * (y - x) >= 1 && direction * (y - x) <= 3 };
}

fun part1(input: List<List<Int>>): Int {
  return input.count(::isValidSequence)
}

fun part2(input: List<List<Int>>): Int {
  return input.count { lst ->
    isValidSequence(lst) || lst.filterIndexed { i, e -> isValidSequence(lst.filterIndexed { j, _ -> i != j }) }
      .isNotEmpty()
  }
}

fun main() {
  val input = parse(readInput("Day02"));
  part1(input).println()
  part2(input).println()
}
