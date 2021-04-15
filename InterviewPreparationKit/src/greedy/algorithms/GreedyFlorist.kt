package greedy.algorithms

fun main(args: Array<String>) {
    val result = getMinimumCost(3, arrayOf(1, 3, 5, 7, 9))
    print(result)
}

fun getMinimumCost(k: Int, c: Array<Int>): Int {
    var cost = 0
    var i = 0

    c.sortDescending()
    c.forEachIndexed { index, element ->
        cost += (i + 1) * element

        if ((index + 1) % k == 0) {
            i++
        }
    }

    return cost
}
