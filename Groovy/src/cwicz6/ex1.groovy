package cwicz6

def list1 = ['a', 'b', 'c']
def list2 = [1, 8, 23]

[list1, list2].each { list ->
    list.each {
        print(it)
        print(" ")
    }
    println()
}

def list11 = []
list1.each { list11.add(it * 2) }

def list12 = []
list2.each { list12.add(2 * it) }

println(list11)
println(list12)

