package linkedlist.traversal_reversal

import linkedlist.traversal_reversal.linkedlist_datastructure.LinkedList
import linkedlist.linkedlist_datastructure.Node

fun main() {
    val list = LinkedList<Int>()
    for (i in 1..5) {
        list.add(i)
    }
    println(removeNthNodeFromEnd(list.head, 2).toString())
    val list2 = LinkedList<Int>()
    list2.add(1)
    println(removeNthNodeFromEnd(list2.head, 1).toString())
}
// 1 -> 2 -> 3 -> 4 -> 5

fun removeNthNodeFromEnd(head: Node<Int>?, n: Int): Node<Int>? {
    val dummy = Node(0)
    dummy.next = head

    var fast: Node<Int>? = dummy
    var slow: Node<Int>? = dummy

    // 1. Create a gap of n+1 between fast and slow.
    // We use n+1 so 'slow' lands RIGHT BEFORE the target node.
    for (i in 0..n) {
        fast = fast?.next
    }

    // 2. Move both until fast reaches the end.
    while (fast != null) {
        fast = fast.next
        slow = slow?.next
    }

    // 3. 'slow' is now at the node BEFORE the target. Remove it.
    slow?.next = slow.next?.next

    return dummy.next // Return the new head (which might be different from the original head)
}