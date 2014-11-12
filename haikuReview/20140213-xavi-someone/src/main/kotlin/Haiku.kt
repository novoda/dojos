/**
 * Created by xrigau on 13/02/2014.
 */


import java.util.Arrays

public open class Haiku2(haiku : String) {

    private val haiku : String

    open fun isValidLineCount() : Boolean {
        return haiku.matches("(.*)/(.*)/(.*)")!!
    }

    public open fun asLines() : java.util.List<String> {
        val split = haiku.split("/")
        val strings = Arrays.asList(split) as java.util.List<String>
        if (isValidLineCount())
            throw RuntimeException("A haiku yoyo, it should be 3 lines only, try again carrot")
        return strings
    }

    {
        this.haiku = haiku
    }
}
