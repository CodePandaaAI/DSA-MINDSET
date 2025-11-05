package linkedlist.traversal

class Node<T>(
    var `val`: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$`val` -> ${next.toString()}"
        } else {
            "$`val`"
        }
    }
}

