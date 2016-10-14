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

//    if (isEmpty(positionsList))

    println("0")
}

//fun isEmpty(positionsList: MutableList<Position>): Boolean {
//    positionsList.filter {  }
//}

enum class Position {
    EMPTY, MINE, OTHER
}
