package playground.lru.cache

interface Cache<K, V> {
    fun set(key: K, value: V)
    fun get(key: K): V?
}

data class Node<K, V>(
    val key: K,
    val value: V,
    var next: Node<K, V>? = null,
    var prev: Node<K, V>? = null
)

class LRUCache<K, V>(private val maxSize: Int) : Cache<K, V> {
    private val cache: MutableMap<K, Node<K, V>> = mutableMapOf()
    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null

    init {
        if (maxSize < 1) {
            throw Exception("Min size is 1")
        }
    }

    override operator fun get(key: K): V? {
        val node = cache[key] ?: return null
        set(key, node.value)
        return node.value
    }

    override operator fun set(key: K, value: V) {
        if (cache.isEmpty() || maxSize == 1) {
            initHeadAndTail(key, value)
        } else if (cache.containsKey(key)) {
            moveKeyToHead(key, value)
        } else if (cache.size == maxSize) {
            addHeadRemoveTail(key, value)
        } else {
            addHead(key, value)
        }
    }

    private fun addHeadRemoveTail(key: K, value: V) {
        head = Node(key, value, head)
        cache.remove(tail?.key)
        tail = tail?.prev
        cache[key] = head!!
    }

    private fun initHeadAndTail(key: K, value: V) {
        cache.clear()
        cache[key] = Node(key, value)
        head = cache[key]
        tail = cache[key]
    }

    private fun addHead(key: K, value: V) {
        val newNode = Node(key, value, head)
        head = newNode
        newNode.next?.prev = newNode
        cache[key] = head!!
    }

    private fun moveKeyToHead(key: K, value: V) {
        val node = cache[key]
        node?.prev?.next = node?.next
        head = Node(key, value, head)
        head?.next?.prev = head
        cache[key] = head!!

        if (node == tail) {
            tail = node?.prev
        }
    }
}

fun main() {
    val cache = LRUCache<Int, Int>(5)

//    val cache2 = LRUCache<Int, Int>(1)

//    cache2.set(1, 1)
//    println(cache2.get(1))
//    cache2.set(2, 2)
//    println(cache2.get(1))

    println("set(1,1)")
    cache[1] = 1
    println("set(2,2)")
    cache[2] = 2
    println("set(3,3)")
    cache[3] = 3
    println("set(4,4)")
    cache[4] = 4

    // returns 1
    val res1 = cache[1]
    println("get(1) expected val: 1, actual val: $res1")

    // returns 2
    val res2 = cache[2]
    println("get(2) expected val: 2, actual val: $res2")

    // returns null because 9 is not present in the cache
    val res3 = cache[9]
    println("get(9) expected val: null, actual val: $res3")

    println("set(5,5)")
    cache[5] = 5
    println("set(6,6)")
    cache[6] = 6

    // returns null because the cache reached its size and 3 was the least recently used entry
    val res4 = cache[3]
    println("get(3) expected val: null, actual val: $res4")
}
