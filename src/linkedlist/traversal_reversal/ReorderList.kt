package linkedlist.traversal_reversal

import linkedlist.traversal_reversal.linkedlist_datastructure.LinkedList
import linkedlist.linkedlist_datastructure.Node

fun main() {
    val list = LinkedList<Int>()
    val list2 = LinkedList<Int>()
    for (i in 1..6) {
        list.add(i)
    }
    list2.add(1)
    println(listMid(head = list.head)?.`val`)
    reorderListEff(head = list.head)
    println(list.toString())
//    println(reorderList(head = list.head).toString())
//    println(reorderList(head = list2.head).toString())
}

fun reorderListEff(head: Node<Int>?) {
    if (head == null || head.next == null) return

    // --- STEP 1: Find Middle ---
    val mid = listMid(head)

    // --- STEP 2: Split & Reverse Second Half ---
    // (This is exactly your code)
    val secondHalfHead = mid?.next
    mid?.next = null

    var prev: Node<Int>? = null
    var current = secondHalfHead
    var next: Node<Int>?

    while (current != null) {
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    // Now 'prev' is the head of the reversed second list (e.g., 6->5->4)

    // --- STEP 3: Merge (Zip) the Two Lists ---
    var first = head
    var second = prev

    while (second != null) {
        val temp1 = first?.next
        val temp2 = second.next

        first?.next = second
        second.next = temp1

        first = temp1
        second = temp2
    }
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
    while (i < lengthOfList) {
        if (leftL < leftList.size) {
            finalList.add(leftList[leftL])
        }
        if (rightL < rightList.size) {
            finalList.add(rightList[rightL])
        }
        leftL++
        rightL++
        i++
    }

    current = head

    i = 0
    while (current != null) {
        current.`val` = finalList[i]
        current = current.next
        i++
    }
    return head
}

fun listMid(head: Node<Int>?): Node<Int>? {
    var slow: Node<Int>? = head
    var fast: Node<Int>? = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}