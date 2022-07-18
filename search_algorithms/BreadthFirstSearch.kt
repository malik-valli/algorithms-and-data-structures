val graph = mutableMapOf<String, Array<String>>()
fun fillGraph() {
    graph["you"] = arrayOf("alice", "steve", "mark")
    graph["alice"] = arrayOf("liza", "marta")
    graph["steve"] = arrayOf("alex", "kira")
    graph["mark"] = arrayOf("matt")
    graph["liza"] = emptyArray()
    graph["marta"] = emptyArray()
    graph["alex"] = emptyArray()
    graph["kira"] = emptyArray()
    graph["matt"] = arrayOf("smith", "marcello")
    graph["smith"] = emptyArray()
    graph["marcello"] = emptyArray()
}

// Breadth-first search algorithm, O(|V|+|E|).
fun breadthFirstSearch(graph: MutableMap<String, Array<String>>, name: String): String {
    val searchQueue = ArrayDeque<String>()
    graph[name]?.forEach { searchQueue.add(it) }
    val searched = arrayListOf<String>()

    fun personIsSpanish(name: String): Boolean {
        if (name[name.lastIndex] == 'o') return true // Condition for finding (in this case this is a joke).
        return false
    }

    while (searchQueue.isNotEmpty()) {
        val person = searchQueue.removeFirst()
        if (!searched.contains(person)) {
            if (personIsSpanish(person)) return person
            else {
                graph[person]?.forEach { searchQueue.add(it) }
                searched.add(person)
            }
        }
    }
    return "none of these people is Spanish"
}
