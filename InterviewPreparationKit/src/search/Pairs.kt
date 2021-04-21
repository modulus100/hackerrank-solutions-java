package search

fun main() {

}


fun pairs(k: Int, arr: Array<Int>): Int {
    val hashSet = mutableSetOf(*arr)
    var count = 0;

    arr.forEach {
        if (hashSet.contains(it + k)) {
            count++
        }
    }
    return count;
}