package cwicz6

def pmap = [Groovy: ['Asia', 'Jan'],
            Grails: ['Asia', 'Jan', 'Stefan', 'Mirek'],
            Java  : ['Asia', 'Stefan', 'Mirek'],
            JEE   : ['Slawek', 'Stefan', 'Janusz']
]

println "a)"
pmap.each { println(it.key + " " + it.value.size()) }

// b)
println "b)"
pmap.each {
    if (it.value.size() > 2)
        println(it.key)
}

println "c)"
def programmers = new HashMap<String, List<String>>()
pmap.each { entry ->
    entry.value.each { value ->
        if (!programmers.containsKey(value)) {
            programmers.put(value, [entry.key])
        } else {
            programmers.get(value).add(entry.key)
        }
    }
}
println(programmers)
