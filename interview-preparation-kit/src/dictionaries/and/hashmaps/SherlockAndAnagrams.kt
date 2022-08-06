package dictionaries.and.hashmaps


fun main(args: Array<String>) {
    sherlockAndAnagrams("abba")
}

fun sherlockAndAnagrams(s: String): Int {
    val map = linkedMapOf<String, Int>()

    for (i in 0..s.length - 1) {
        for (j in i..s.length - 1) {
            val subStr = s.substring(i, j + 1).toCharArray().sorted().joinToString("")
            if (map.containsKey(subStr)) {
                map[subStr] = map[subStr]!! + 1
            } else {
                map[subStr] = 1
            }
        }
    }

    var count = 0
    map.forEach { (_, v) -> count += ((v - 1) * v / 2) }
    return count
}