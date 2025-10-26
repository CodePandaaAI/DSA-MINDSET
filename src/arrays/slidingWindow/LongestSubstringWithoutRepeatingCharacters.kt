package arrays.slidingWindow

import kotlin.math.max

fun main() {
    val s = "pwwkew"
    print(longestSubStringWithoutRepeatingCharacters(s))
}

fun longestSubStringWithoutRepeatingCharacters(s: String): Int {
    val seen = hashMapOf<Char, Int>()
    var maxSize = 0

    var left = 0

    for (right in 0 until s.length) {
        val ch = s[right]
        seen[s[right]] = seen.getOrDefault(ch, 0) + 1

        while (seen[ch]!! > 1) {
            seen[s[left]] = seen.getOrDefault(s[left], 0) - 1
            if (seen[s[left]] == 0) seen.remove(s[left])
            left++
        }

        maxSize = max(right - left + 1, maxSize)
    }
    return maxSize
}