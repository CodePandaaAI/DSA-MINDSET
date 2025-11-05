package linkedlist.traversal

//class LinkedList<T> {
//    private var head: Node<T>? = null
//    private var tail: Node<T>? = null
//    var size = 0
//        private set
//
//    fun add(value: T) {
//        val newNode = Node(value)
//        if (head == null) {
//            head = newNode
//            tail = newNode
//        } else {
//            tail?.next = newNode
//            tail = newNode
//        }
//        size++
//    }
//
//    fun addFirst(value: T) {
//        val newNode = Node(value)
//
//        newNode.next = head
//        head = newNode
//        if (tail == null) {
//            tail = newNode
//        }
//        size++
//    }
//
//    fun removeFirst(): T? {
//        if (head == null) return null
//        val value = head?.`val`
//        head = head?.next
//
//        size--
//
//        if (head == null) {
//            tail = null
//        }
//        return value
//    }
//
//    fun getHead(): Node<T>? = head
//
//    fun setHead(node: Node<T>?) {
//        head = node
//    }
//
//    fun find(value: T): Boolean {
//        var current = head
//        while (current != null) {
//            if (current.`val` == value) return true
//            current = current.next
//        }
//        return false
//    }
//
//    override fun toString(): String {
//        return buildString {
//            var current = head
//            append("[")
//            while (current != null) {
//                append(current.`val`)
//                if (current.next != null) append(" -> ")
//                current = current.next
//            }
//            append("]")
//        }
//    }
//
//    fun isEmpty(): Boolean = head == null
//}

class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    var size: Int = 0
        private set

    fun add(value: T) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    fun addFirst(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
            tail = newNode
            size++
            return
        }

        newNode.next = head
        head = newNode
        size++
    }

    fun removeFirst(): T? {
        if (head == null) return null

        val oldNodeValue = head?.`val`
        head = head?.next

        if (head == null) tail = null

        size--

        return oldNodeValue
    }

    fun find(value: T): Boolean {
        var current = head

        while (current != null){
            if(current.`val` == value) return true
            current = current.next
        }
        return false
    }

    override fun toString(): String {
        return buildString {
            var current = head
            append("[")
            while (current != null){
                append(current.`val`)
                if (current.next != null) append(" -> ")
                current = current.next
            }
            append("]")
        }
    }
}