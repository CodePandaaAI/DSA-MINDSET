package linkedlist.traversal

fun main() {
    val linkedList = LinkedList<Int>()
    for (i in 1..5) linkedList.add(i)
    print(reverseLinkedListEff(head = linkedList.head).toString())
}

fun reverseLinkedListInEfficient(head: Node<Int>?) {
    val list = mutableListOf<Int>()

    var current = head

    while (current != null) {
        list.add(current.`val`)
        current = current.next
    }
    current = head

    for (i in list.size - 1 downTo 0) {
        current!!.`val` = list[i]
        current = current.next
    }
}

fun reverseLinkedListEff(head: Node<Int>?): Node<Int>? {
    var prev: Node<Int>? = null
    var current = head
    var next: Node<Int>?

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}