package sorting


fun countSwaps(a: Array<Int>): Unit {
    var swapCount = 0

    for (i in a.indices) {
        for (j in 0.. a.size - 2) {
            if (a[j] > a[j + 1]) {
                swapCount++
                run {
                    val temp = a[j]
                    a[j] = a[j + 1]
                    a[j + 1] = temp
                }
            }
        }
    }

    println("Array is sorted in $swapCount swaps.")
    println("First Element: " + a[0])
    println("Last Element: " + a.last())
}