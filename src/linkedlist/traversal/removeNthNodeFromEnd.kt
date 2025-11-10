package linkedlist.traversal

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
    // 1. Calculate the total length of the list
    var length = 0
    var current = head
    while (current != null) {
        length++
        current = current.next
    }

    // 2. Handle Edge Case: Removing the head
    // If n equals the length, we need to remove the first node.
    if (length == n) {
        return head?.next
    }

    // 3. Find the node BEFORE the one we want to remove
    // The target index to remove is (length - n).
    // We want to stop at (length - n - 1).
    var indexToStop = length - n - 1
    current = head
    for (i in 0 until indexToStop) {
        current = current?.next
    }

    // 4. Remove the node
    current?.next = current?.next?.next

    return head
}