package class2.ex5

def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s as Iterable) { a, b -> // errors without casting to Iterable
    out << b << a
}
println out

def static eachTuple(Iterable iter, Closure c) { // can't use collate without specifying type
    iter.collate(c.maximumNumberOfParameters).each(c)
}