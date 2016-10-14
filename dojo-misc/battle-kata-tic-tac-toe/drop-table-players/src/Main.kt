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

    if (isRowWithTwo(positionsList, 0, 1, 2) != -1) return
    if (isRowWithTwo(positionsList, 3, 4, 5) != -1) return
    if (isRowWithTwo(positionsList, 6, 7, 8) != -1) return

    if (isRowWithTwo(positionsList, 0, 3, 6) != -1) return
    if (isRowWithTwo(positionsList, 1, 4, 7) != -1) return
    if (isRowWithTwo(positionsList, 2, 5, 8) != -1) return

    if (isRowWithTwo(positionsList, 0, 4, 8) != -1) return
    if (isRowWithTwo(positionsList, 6, 4, 2) != -1) return

    val firstEmpty = getFirstEmpty(positionsList)
    println("$firstEmpty")
}



fun isRowWithTwo(positionsList: MutableList<Position>, vararg positions: Int): Int {
    if (isFull(positionsList, positions)
            || isOnlyOneUsed(positionsList, positions)
            || twoDifferent(positionsList, positions)) {
        return -1
    }
    positions.forEach {
        if (positionsList[it] == Position.EMPTY) {
            println("$it")
            return it
        }
    }
    return -1
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

fun isEmpty(positionsList: MutableList<Position>): Boolean {
    if (positionsList.filter { it == Position.EMPTY }
            .size == 9) return true
    else return false
}

enum class Position {
    EMPTY, MINE, OTHER
}
