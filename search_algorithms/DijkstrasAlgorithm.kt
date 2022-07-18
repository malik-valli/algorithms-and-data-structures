val graph = mutableMapOf<String, Map<String, Int>>()
val costs = mutableMapOf<String, Int>()
val parents = mutableMapOf<String, String?>()

const val START = "START"
const val A = "A"
const val B = "B"
const val C = "C"
const val FINISH = "FINISH"

fun fillMaps() {
    graph[START] = mapOf(A to 2, C to 2)
    graph[A] = mapOf(FINISH to 2, B to 2)
    graph[B] = mapOf(FINISH to 2, C to -1)
    graph[C] = mapOf(A to 2)
    graph[FINISH] = emptyMap()

    costs[START] = 0
    graph[START]?.forEach { costs[it.key] = graph[START]?.get(it.key)!! }
    graph.forEach { if (!costs.keys.contains(it.key)) costs[it.key] = Int.MAX_VALUE }

    graph[START]?.forEach { parents[it.key] = START }
    graph.forEach { if (!parents.keys.contains(it.key)) parents[it.key] = null }
    parents[FINISH] = null
}

fun dijkstrasAlgorithm(): String {
    fillMaps()
    val processed = mutableListOf<String>()

    fun findLowestCostNode(): String? {
        var min = Int.MAX_VALUE
        var result: String? = null
        costs.forEach {
            if (processed.contains(it.key)) return@forEach
            if (it.value < min) {
                min = it.value
                result = it.key
            }
        }
        return result
    }

    fun showParentsTree(node: String): String {
        return if (parents[node] != null) showParentsTree(parents[node]!!) + " -> " + node
        else node
    }

    var node = findLowestCostNode()

    while (node != null) {
        val cost = costs[node]
        val neighbors = graph[node]
        neighbors?.forEach {
            val newCost = cost?.plus(neighbors[it.key]!!)
            if (costs[it.key] != null && costs[it.key]!! > newCost!!) {
                costs[it.key] = newCost
                parents[it.key] = node
            }
        }
        processed.add(node)
        node = findLowestCostNode()
    }

    return "Shortest length is ${costs[FINISH]!!}. The way looks like this: ${showParentsTree(FINISH)}"
}
