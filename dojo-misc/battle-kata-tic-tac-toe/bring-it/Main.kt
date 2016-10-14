fun main(args: Array<String>) {
    val boardAsArray: List<String> = args[0].split(",")

    var importantSquare = preventWinningMoves(
            Pair(0, args[0]),
            Pair(1, args[1]),
            Pair(2, args[2]),
            args[1]
    )

    if (importantSquare == -1) {
        importantSquare = preventWinningMoves(
                Pair(0, args[0]),
                Pair(3, args[3]),
                Pair(6, args[6]),
                args[1]
        )
    }

    if (boardAsArray[4] == "-") {
        print("4")
    } else if (importantSquare != -1) {
        print(importantSquare.toString())
    } else {
        print(boardAsArray.indexOf("-"))
    }
}

fun preventWinningMoves(firstSquare: Pair<Int, String>,
                        secondSquare: Pair<Int, String>,
                        thirdSquare: Pair<Int, String>,
                        enemyCounter: String): Int {
    if (firstSquare.second == enemyCounter && secondSquare.second == enemyCounter && thirdSquare.second == "-") {
        return thirdSquare.first
    } else if (secondSquare.second == enemyCounter && thirdSquare.second == enemyCounter && firstSquare.second == "-") {
        return firstSquare.first
    } else if (firstSquare.second == enemyCounter && thirdSquare.second == enemyCounter && secondSquare.second == "-") {
        return secondSquare.first
    }
    return -1
}


val listOfConsecutiveSquares: List<Triple<Int, Int, Int>> = listOf(
        Triple(0, 1, 2),
        Triple(3, 4, 5),
        Triple(6, 7, 8),
        Triple(0, 3, 6),
        Triple(1, 4, 7),
        Triple(2, 5, 8),
        Triple(0, 4, 8),
        Triple(2, 4, 6)
)

fun squareFor(index: Int, squares: List<String>): Pair<Int, String> {
    return Pair(index, squares[index])
}
