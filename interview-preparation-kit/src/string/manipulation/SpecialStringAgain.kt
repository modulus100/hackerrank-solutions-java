package string.manipulation

fun main() {
    val str = "mnonopoo"
    print(substrCount(str.length, str))
}

fun substrCount(length: Int, s: String): Long {
    var counter: Long = 0
    var i = 0
    while (i < length) {

        // if the current symbol is in the middle of palindrome, e.g. aba
        var offset = 1
        while (i - offset >= 0 && i + offset < length && s[i - offset] == s[i - 1] && s[i + offset] == s[i - 1]) {
            counter++
            offset++
        }
        // if this is repeatable characters aa
        var repeats = 0
        while (i + 1 < length && s[i] == s[i + 1]) {
            repeats++
            i++
        }
        counter += (repeats * (repeats + 1) / 2).toLong()
        i++
    }
    return counter + length
}