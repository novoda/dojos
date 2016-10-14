fun main(board: String, counterType: String) {
    var myCounter: String
    if (counterType == "0") {
        myCounter = "X"
    }
    if (counterType == "X") {
        myCounter = "0"
    }

    val boardAsArray: List<String> = board.split(",")

    System.out.println(boardAsArray.indexOf("-".toString()))
}
