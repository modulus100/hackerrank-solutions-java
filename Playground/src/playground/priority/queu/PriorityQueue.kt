package playground.priority.queu

import java.util.*

fun main() {
//    val comparator: Comparator<Node> = compareBy { it.number }
    val queue = PriorityQueue<Node>(compareByDescending { it.number })

    queue.add(Node(1))
    queue.add(Node(2))
    queue.add(Node(3))

    while (!queue.isEmpty()) {
        val node = queue.poll()
        println(node)
    }
}

data class Node(val number: Int)