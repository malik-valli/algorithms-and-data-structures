fun bubbleSort(list: MutableList<Int>) {
    var isSorted = false
    while (!isSorted) {
        var isChanged = false
        for (i in 0 until list.size) {
            if (i == list.size - 1) {
                if (!isChanged) isSorted = true
                break
            }
            if (list[i] > list[i + 1]) {
                isChanged = true
                val greater = list[i]
                list[i] = list[i + 1]
                list[i + 1] = greater
            }
        }
    }
}
