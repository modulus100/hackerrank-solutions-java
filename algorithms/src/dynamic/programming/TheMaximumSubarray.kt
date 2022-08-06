package dynamic.programming


fun main() {
    val arr = maxSubarray(arrayOf(2, -1, 2, 3, 4, -5))
    val subArrSum = arr[0]
    val suSeqSum = arr[1]

    print("Max subArrSum $subArrSum Max subSeqSum $suSeqSum")
}

data class Node(
        val totalSum: Int = 0,
        val positiveSum: Int = 0,
        val isLeaf: Boolean = false,
        val deliveryNode: Boolean = false)

fun maxSubarray(arr: Array<Int>): Array<Int> {
    val start = 0
    val stop = arr.size - 1
    val node = maxSubarrayRecursive(arr, start, stop)

    if (node.totalSum > node.positiveSum) {
        return arrayOf(node.totalSum, node.totalSum)
    }

    if (node.totalSum > 0) {
        return arrayOf(node.totalSum, node.positiveSum)
    }

    return arrayOf(node.totalSum, node.totalSum)
}

fun maxCrossingSum(arr: Array<Int>, start: Int, mid: Int, stop: Int): Node {
    var leftSum = arr[mid]
    var leftSumMax = arr[mid]

    for (i in mid - 1 downTo start) {
        leftSum += arr[i]
        if (leftSum > leftSumMax) {
            leftSumMax = leftSum
        }
    }

    var rightSum = arr[mid + 1]
    var rightSumMax= arr[mid + 1]

    for (i in mid + 2 until stop + 1) {
        rightSum += arr[i]
        if (rightSum > rightSumMax) {
            rightSumMax = rightSum
        }
    }

    return Node(rightSumMax + leftSumMax)
}

fun getDeliverySum(right: Node, left: Node, crossing: Node): Int {
    var deliverySum = 0

    if (right.deliveryNode) {
        deliverySum += right.positiveSum
    }

    if (left.deliveryNode) {
        deliverySum += left.positiveSum
    }

    if (crossing.deliveryNode) {
        deliverySum += crossing.positiveSum
    }

    return deliverySum
}

fun getSubSeqSum(right: Node, left: Node, crossing: Node): Int {
    var subSeqSum = 0

    if (right.isLeaf && right.totalSum > 0) {
        subSeqSum += right.totalSum
    }

    if (left.isLeaf && left.totalSum > 0) {
        subSeqSum += left.totalSum
    }

    if (crossing.isLeaf && crossing.totalSum > 0) {
        subSeqSum += crossing.totalSum
    }

    return subSeqSum
}

fun getMaxNode(right: Node, left: Node, crossing: Node): Node {
    val deliverySum = getDeliverySum(right, left, crossing)
    val subSeqSum = getSubSeqSum(right, left, crossing)
    val maxSum = Math.max(crossing.totalSum, Math.max(right.totalSum, left.totalSum))
    val newSubSeqSum = deliverySum + subSeqSum

    if (right.totalSum == maxSum) {
        return Node(right.totalSum, newSubSeqSum, isLeaf = false, deliveryNode = true)
    }

    if (left.totalSum == maxSum) {
        return Node(left.totalSum, newSubSeqSum, isLeaf = false, deliveryNode = true)
    }

    return Node(crossing.totalSum, newSubSeqSum, isLeaf = false, deliveryNode = true)
}

fun maxSubarrayRecursive(arr: Array<Int>, start: Int, stop: Int): Node {
    if (start == stop) {
        return Node(arr[start], 0, true)
    }

    if (start < stop) {
        val mid = (start + stop) / 2
        val leftNode = maxSubarrayRecursive(arr, start, mid)
        val rightNode = maxSubarrayRecursive(arr, mid + 1, stop)
        val crossingNode = maxCrossingSum(arr, start, mid, stop)
        return getMaxNode(leftNode, rightNode, crossingNode)
    }

    return Node()
}