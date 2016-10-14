fun main(board: String, counterType: String) {
    var myCounter: String
    if (counterType == "0") {
        myCounter = "X"
    }
    if (counterType == "X") {
        myCounter = "0"
    }

    val boardAsArray: List<String> = board.split(",")

    if (boardAsArray[4] == "-") {
        System.out.println("4")
    } else {
        System.out.println(boardAsArray.indexOf("-"))
    }
}
