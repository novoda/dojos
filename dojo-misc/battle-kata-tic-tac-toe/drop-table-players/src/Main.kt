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

//    isRowWithTwo(positionsList, 0, 1, 2)

    val firstEmpty = getFirstEmpty(positionsList)
    println("$firstEmpty")
}



fun isRowWithTwo(positionsList: MutableList<Position>, vararg positions: Int) {
    if (isFull(positionsList, positions)) {
        return
    }
    positions.forEach {

    }
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
