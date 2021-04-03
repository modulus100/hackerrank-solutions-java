package greedy

import kotlin.math.abs

fun main(args: Array<String>) {
    print(minimumAbsoluteDifference(arrayOf()))
}

fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    arr.sort()
    var minAbs = Int.MAX_VALUE

    for (i in 0..arr.size - 2) {
        minAbs = minAbs.coerceAtMost(abs(arr[i] - arr[i + 1]))
    }

    return minAbs;
}