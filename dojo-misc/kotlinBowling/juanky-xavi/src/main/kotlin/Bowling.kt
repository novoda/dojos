fun score(plays: List<Int>): Int {
    return plays
            .flatMap(addZerosAfterTens())
            .toPairs()
            .fold(listOf(), { score, acc -> score + acc })
}

private fun addZerosAfterTens(): (Int) -> Iterable<Int> {
    return {
        if (it == 10) {
            listOf(it, 0)
        } else {
            listOf(it)
        }
    }
}


fun List<Int>.toPairs(): List<Pair<Int, Int?>> {
    return makePairs(this, listOf())
}

fun List<Int>.makePairs(list: List<Int>, accumulator: List<Pair<Int, Int?>>): List<Pair<Int, Int?>> {
    if (list.isEmpty()) {
        return accumulator
    }
    val pairs = accumulator.plus(list.firstPair().invoke())
    val rest = list.drop(2)
    return makePairs(rest, pairs)
}

fun List<Int>.firstPair() = {
    Pair(get(0), getOrNull(1))
}
