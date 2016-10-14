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
    if (firstSquare.second == enemyCounter && secondSquare.second == enemyCounter) {
        return thirdSquare.first
    } else if (secondSquare.second == enemyCounter && thirdSquare.second == enemyCounter) {
        return firstSquare.first
    } else if (firstSquare.second == enemyCounter && thirdSquare.second == enemyCounter) {
        return secondSquare.first
    }
    return -1
}
