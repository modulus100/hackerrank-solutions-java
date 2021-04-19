package greedy.algorithms

import java.util.*

fun main() {
    maxMin(3, arrayOf(1, 2, 3, 4, 5))
}

fun maxMin(k: Int, arr: Array<Int>): Int {
    val list = LinkedList<Int>()
    var min = Int.MAX_VALUE

    arr.sort()

    arr.forEach {
        list.add(it)

        if (list.size == k) {
            if (list.last - list.first < min) {
                min = list.last - list.first
            }

            list.removeFirst()
        }
    }

    return min;
}