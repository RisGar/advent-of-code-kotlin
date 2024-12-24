fun part1(input: String): Int =
  """mul\((\d{1,3}),(\d{1,3})\)""".toRegex().findAll(input).fold(0) { acc, match ->
    acc + match.destructured.component1().toInt() * match.destructured.component2().toInt()
  }

fun part2(input: String): Int {
  val regex = """do\(\)|don't\(\)""".toRegex();
  val matches = regex.findAll(input).map { it.value }.toList()
  return regex.split(input).mapIndexed { index, text ->
    listOfNotNull(
      text.takeIf { it.isNotBlank() }?.trim(),
      matches.getOrNull(index)
    )
  }.flatten().fold(Pair(0, true)) { (acc, enabled), match ->
    when (match) {
      "do()" -> Pair(acc, true)
      "don't()" -> Pair(acc, false)
      else -> if (enabled) Pair(acc + part1(match), true) else Pair(acc, false)
    }
  }.first
}


fun main() {
  val parse = readInputFull("Day03")
  part1(parse).println()
  part2(parse).println()
}
