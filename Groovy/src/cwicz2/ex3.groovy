package cwicz2

print apply([1, 2, 3], { a -> a + 1 })

static List apply(List l, Closure c) {
    //return l.collect(c)
    def transformed = new ArrayList()
    l.each { transformed.add(c(it)) }
    return transformed
}