

fun score(plays: List<Int>): Int {
    return plays.fold(0, {a, b -> a + b})
}
