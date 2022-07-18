fun selectionSort(list: MutableList<Int>): MutableList<Int> {
    for (i in 0 until list.size) {
        var min = list[i]
        var minIndex = i
        for (x in i until list.size) {
            if (list[x] < min) {
                min = list[x]
                minIndex = x
            }
        }
        list[minIndex] = list[i]
        list[i] = min
    }
    return list
}
