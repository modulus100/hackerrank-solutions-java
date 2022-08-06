package search

fun pairs(k: Int, arr: Array<Int>): Int {
    val hashSet = mutableSetOf(*arr)
    return arr.count { hashSet.contains(it + k) }
}
