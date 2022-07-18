// Quicksort sort algorithm, O(n log n).
fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list
    if (list.size == 2) return if (list[0] > list[1]) list.reversed() else list

    val pivot = (list.size - 1) / 2
    val less = mutableListOf<Int>()
    val greater = mutableListOf<Int>()

    for (i in 0 until pivot) {
        if (list[i] > list[pivot]) greater.add(list[i])
        else less.add(list[i])
    }
    for (i in (pivot + 1) until list.size) {
        if (list[i] > list[pivot]) greater.add(list[i])
        else less.add(list[i])
    }

    return quickSort(less) + list[pivot] + quickSort(greater)
}
