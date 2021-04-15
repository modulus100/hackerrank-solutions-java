package dynamic.programming

import kotlin.math.max

fun main(args: Array<String>) {
    print(maxSubsetSum(arrayOf(5,  5, 10, 40, 50, 35)))
}

fun maxSubsetSum(arr: Array<Int>): Int {
    var currentSum = arr[0]
    var newCurrentSum: Int
    var prevSum = 0

    arr.drop(1).forEach { element ->
        newCurrentSum = prevSum + element
        prevSum = max(prevSum, currentSum)
        currentSum = newCurrentSum
    }

    return max(prevSum, currentSum)
}