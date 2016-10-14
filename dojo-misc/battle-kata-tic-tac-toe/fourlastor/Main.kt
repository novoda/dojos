package demo

fun main(args: Array<String>) {
    val player = args[1].toPlayer()
    val state = args[0].toState(player)

    println(state.nextMove())
}

private fun String.toState(player: Player): State {
    val moves = this.split(",").map(String::toPlayer)

    return State(player, moves)
}

private fun String.toPlayer(): Player {
    if ("0" == this) {
        return Player.ZERO
    } else if ("X" == this) {
        return Player.ICS
    }

    return Player.UNPLAYED
}


enum class Player {
    ZERO,
    ICS,
    UNPLAYED
}


class State(private val player: Player, private val moves: List<Player>) {
    fun nextMove(): Int {
        return blockWinningMove() ?: tryToCenter() ?: tryToWin() ?: putFirstCorner() ?: putFirstEdge()!!
    }

    private fun blockWinningMove(): Int? {
        return completingMoveFor(player)
    }

    private fun completingMoveFor(player: Player): Int? {
        moves.forEachIndexed outer@ { i, move ->
            if (move == Player.UNPLAYED || move == player) return@outer

            moves.forEachIndexed inner@ { j, otherMove ->
                if (i == j || otherMove != move) {
                    return@inner
                }

                val col1 = i % 3
                val col2 = j % 3

                val row1: Int = i / 3
                val row2: Int = j / 3

                if (col1 == col2) {
                    val row = listOf(0, 1, 2).minus(row1).minus(row2).first()
                    return moveNum(col1, row)
                }

                if (row1 == row2) {
                    val col = listOf(0, 1, 2).minus(col1).minus(col2).first()
                    return moveNum(col, row1)
                }

                if (col1 == row1 && col2 == row2) {
                    val place = listOf(0, 1, 2).minus(col1).minus(col2).first()
                    return moveNum(place, place)
                }
            }
        }

        return null
    }

    private fun moveNum(col: Int, row: Int): Int {
        return row * 3 + col
    }

    private fun tryToCenter(): Int? {
        if (emptyCenter()) return 4

        return null
    }

    private fun tryToWin(): Int? {
        val other = if (player == Player.ICS) Player.ZERO else Player.ICS

        return completingMoveFor(other)
    }

    private fun putFirstCorner(): Int? {
        return findEmpty(listOf(0, 2, 6, 8))
    }

    private fun findEmpty(moves: List<Int>): Int? {
        moves.forEach {
            if (this.moves[it] == Player.UNPLAYED) {
                return it
            }
        }

        return null
    }

    private fun putFirstEdge(): Int? {
        return findEmpty(listOf(1, 3, 5, 7))
    }

    private fun emptyCenter(): Boolean = moves[4] == Player.UNPLAYED
}


