fun main(args: Array<String>) {
    var myCounter: String
    if (counterType == "0") {
        myCounter = "X"
    }
    if (counterType == "X") {
        myCounter = "0"
    }

    val boardAsArray: List<String> = board.split(",")

    if (boardAsArray[4] == "-") {
        print("4")
    } else {
        print(boardAsArray.indexOf("-"))
    }
}
