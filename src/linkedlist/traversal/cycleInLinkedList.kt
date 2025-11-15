package linkedlist.traversal

fun main() {
    val list = LinkedList<Int>()

    list.add(3)
    list.add(2)
    val tailfirst = list.tail
    list.add(0)
    list.add(-4)
    val tailSecond = list.tail
    tailSecond?.next = tailfirst

    println(linkedListCycle(list.head))
}

fun linkedListCycle(head: Node<Int>?): Boolean {
    var fast = head
    var slow = head

    while(fast != null && fast.next != null) {
        fast = fast.next?.next
        slow = slow?.next

        if (fast == slow){
            return true
        }
    }

    return false
}