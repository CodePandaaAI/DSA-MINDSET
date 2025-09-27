package phase1.coreFunctions.numberLogic.arrays.concepts.slidingwindow

fun main() {
    val str = "Hello"
    print(longestSubstring(str))
}

fun longestSubstring(str: String): Int {
    if (str.isBlank()) return -1

    val seen = mutableSetOf<Char>()

    var left = 0
    var maxLen = 0

    for (right in str.indices) {


        while ( str[right] in seen) {
            seen.remove(str[left])
            left++
        }
        seen.add(str[right])

        maxLen = maxOf(maxLen, right - left + 1)
    }
    return maxLen
}