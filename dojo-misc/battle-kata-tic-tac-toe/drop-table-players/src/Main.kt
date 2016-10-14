fun main(args: Array<String>) {
    val boardArray = args[0].split(',')
    val key = args[1]
    val positionsList: MutableList<Position> = mutableListOf()
    boardArray.forEach {
        when (it) {
            "-" -> positionsList.add(Position.EMPTY)
            key -> positionsList.add(Position.MINE)
            else -> positionsList.add(Position.OTHER)
        }
    }

    if (isEmpty(positionsList)) {
        println("8")
        return
    }

    if (twoOutOfThreeSameOccupied(positionsList, 0, 1, 2)) return
    if (twoOutOfThreeSameOccupied(positionsList, 3, 4, 5)) return
    if (twoOutOfThreeSameOccupied(positionsList, 6, 7, 8)) return

    if (twoOutOfThreeSameOccupied(positionsList, 0, 3, 6)) return
    if (twoOutOfThreeSameOccupied(positionsList, 1, 4, 7)) return
    if (twoOutOfThreeSameOccupied(positionsList, 2, 5, 8)) return

    if (twoOutOfThreeSameOccupied(positionsList, 0, 4, 8)) return
    if (twoOutOfThreeSameOccupied(positionsList, 6, 4, 2)) return

    val firstEmpty = getFirstEmpty(positionsList)
    println("$firstEmpty")
}

fun isEmpty(positionsList: MutableList<Position>): Boolean {
    if (positionsList.filter { it == Position.EMPTY }
            .size == 9) return true
    else return false
}

fun twoOutOfThreeSameOccupied(positionsList: MutableList<Position>, vararg positions: Int): Boolean {
    if (isFull(positionsList, positions)
            || isOnlyOneUsed(positionsList, positions)
            || twoDifferent(positionsList, positions)) {
        return false
    }
    positions.forEach {
        if (positionsList[it] == Position.EMPTY) {
            println("$it")
            return true
        }
    }
    return false
}

fun twoDifferent(positionsList: MutableList<Position>, positions: IntArray): Boolean {
    var firstFound = Position.EMPTY
    var firstId: Int = -1
    positions.forEach {
        if (positionsList[it] != Position.EMPTY) {
            firstFound = positionsList[it]
            firstId = it
        }
    }
    positions.forEach {
        if (positionsList[it] != Position.EMPTY && firstId != it && positionsList[it] != firstFound) {
            return true
        }
    }
    return false
}

fun isOnlyOneUsed(positionsList: MutableList<Position>, positions: IntArray): Boolean {
    var found = 0
    positions.forEach {
        if (positionsList[it] != Position.EMPTY) {
            found++
        }
    }
    if (found == 1) return true
    else return false
}

fun isFull(positionsList: MutableList<Position>, positions: IntArray): Boolean {
    positions.forEach {
        if (positionsList[it] == Position.EMPTY) {
            return false
        }
    }
    return true
}

fun getFirstEmpty(positionsList: MutableList<Position>): Int {
    for (i in 0..8) {
        if (positionsList[i] == Position.EMPTY) return i
    }
    return 0
}

enum class Position {
    EMPTY, MINE, OTHER
}
