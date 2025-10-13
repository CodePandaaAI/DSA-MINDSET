package arrays.hashing

fun main() {
    val s = "aaacbaebabacd"
    val p = "abc"
    print(findAnagrams(s, p).contentToString())
}

fun findAnagrams(s: String, p: String): IntArray {
    if (s.length < p.length) return intArrayOf()

    val indexes = mutableListOf<Int>()

    val pFreq = IntArray(26)
    val sFreq = IntArray(26)

    for (i in p.indices) {
        pFreq[p[i] - 'a']++
        sFreq[s[i] - 'a']++
    }

    if (sFreq.contentEquals(pFreq)) indexes.add(0)

    for (i in p.length until s.length) {
        val right = s[i]
        sFreq[right - 'a']++

        val left = s[i - p.length]
        sFreq[left - 'a']--

        if(sFreq.contentEquals(pFreq)) indexes.add(i - p.length + 1)
    }
    return indexes.toIntArray()
}