
fun main() {
    val test = "test, .01"
    println(matches(test))
}

fun matches(str: String) = "[A-Za-z0-9,. ]+".toRegex().matches(str)