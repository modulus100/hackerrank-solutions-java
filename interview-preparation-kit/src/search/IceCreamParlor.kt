package search


fun main(args: Array<String>) {
    whatFlavors(arrayOf(1, 4, 5, 3, 2), 4)
}

fun whatFlavors(cost: Array<Int>, money: Int): Unit {
    val costMap = mutableMapOf<Int, Int>()

    cost.forEachIndexed { index, element ->
        val diff = money - element
        if (costMap.containsKey(diff)) {
            val firstIndex = costMap[diff]!! + 1
            val secondIndex = index + 1
            println("$firstIndex $secondIndex")
            return
        } else {
            costMap[element] = index
        }
    }
}

// why they work differently ??
/*
def whatFlavors(cost, money):
    cost_dict = {}
    for i,icost in enumerate(cost):
        if money-icost in cost_dict:
            print(str(cost_dict[money-icost]+1) + ' ' + str(i+1))
            return
        else:
            cost_dict[icost] = i*/
