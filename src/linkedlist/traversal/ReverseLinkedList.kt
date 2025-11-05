package linkedlist.traversal

fun main() {
    val linkedList = LinkedList<Int>()
    for (i in 1..5) linkedList.add(i)
    val list = mutableListOf<Int>()

    var current = linkedList.head

    while (current != null) {
        list.add(current.`val`)
        current = current.next
    }
    list.reverse()
    current = linkedList.head

    for (num in list) {
        current!!.`val` = num
        current = current.next
    }
    print(linkedList.toString())
}