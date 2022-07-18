// Binary search algorithm, O(log n).
fun binarySearch(list: List<Int>, target: Int): Int {
    if (list.lastIndex == 0 && list[0] != target)
        return -1

    val mid = list.lastIndex / 2

    return if (list[mid] == target)
        mid
    else if (list[mid] > target)
        mid - 1 - binarySearch(list.subList(0, mid), target)
    else
        mid + 1 + binarySearch(list.subList(mid + 1, list.size), target)
}
