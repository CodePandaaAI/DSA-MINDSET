package linkedlist.traversal

fun main() {
    val list = LinkedList<Int>()
    val list2 = LinkedList<Int>()
    for (i in 1..7) {
        list.add(i)
    }
    list2.add(1)
    println(reorderList(head = list.head).toString())
    println(reorderList(head = list2.head).toString())
}

// 1, 2, 3, 4, 5
fun reorderList(head: Node<Int>?): Node<Int>? {
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    var lengthOfList = 0

    var current = head
    while (current != null) {
        lengthOfList++
        current = current.next
    }

    val mid = lengthOfList / 2

    current = head
    var i = 0

    while (current != null) {
        if (i <= mid) leftList.add(current.`val`)
        else rightList.add(current.`val`)
        i++
        current = current.next
    }

    rightList.reverse()

    var leftL = 0
    var rightL = 0

    i = 0

    val finalList = mutableListOf<Int>()
    while (i < lengthOfList){
        if(leftL < leftList.size){
            finalList.add(leftList[leftL])
        }
        if(rightL < rightList.size){
            finalList.add(rightList[rightL])
        }
        leftL++
        rightL++
        i++
    }

    current = head

    i = 0
    while (current != null){
        current.`val` = finalList[i]
        current = current.next
        i++
    }
    return head
}

