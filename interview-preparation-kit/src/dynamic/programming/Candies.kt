package dynamic.programming

fun main() {
    val test = arrayOf(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)
    candies(10 , test)
}

fun candies(n: Int, arr: Array<Int>): Long {
    val coefs = LongArray(n) { 1 }

    for (i in 1 until n) {
        if (arr[i] > arr[i-1]) {
            coefs[i] = coefs[i - 1] + 1
        }
    }

    for (i in n - 1 downTo 1) {
        if (arr[i - 1] > arr[i] && coefs[i - 1] <= coefs[i]) {
            coefs[i - 1] = coefs[i] + 1
        }
    }

    return coefs.sum()
}