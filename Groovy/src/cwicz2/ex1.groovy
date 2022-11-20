package cwicz2

(maxVal, indList) = maximum([5, 3, 5, 5, 1, 5])
println "Maximum: $maxVal"
println "Indexes: $indList"

(maxVal, indList) = maximum(['a', 'c', 'c', 'c', 'b'])
println "Maximum: $maxVal"
println "Indexes: $indList"

static def maximum(List list) {
    def currMax = 0
    def indices = new ArrayList<>()
    list.eachWithIndex { entry, int i ->
        if (entry >= currMax) {
            if (entry > currMax) {
                indices.clear()
                currMax = entry
            }
            indices.add(i)
        }
    }
    return [currMax, indices]
}