//file:noinspection GroovyAssignabilityCheck
package cwicz2

//def myFib
//myFib = { n -> n <= 1 ? 1G : myFib.trampoline(n - 1) + myFib.trampoline(n - 2) }.trampoline()
//println myFib(300)
//// doesn't work with two method calls

def fibTrampoline

fibTrampoline = { first = 0G, second = 1G, n ->
    (n == 0) ? second : fibTrampoline.trampoline(second, first + second, n - 1)
}.trampoline()

println fibTrampoline(300)

def fib

fib = { first = 0G, second = 1G, n ->
    (n == 0) ? second : fib(second, first + second, n - 1)
}

try {
    println fib(300)
} catch (StackOverflowError ignored) {
    println "Błąd!"
}

//////////////////////

println()


def bigNumber = { BigInteger i ->
    def result = i**i
    println(result)
    return result
}

def sum0 = 0G
for (i in 0..<100) {
    sum0 += i % 2 == 0 ? bigNumber(20) : bigNumber(21)
}

println 'suma 0: ' + sum0


def bigNumberMemoize = { BigInteger i ->
    def result = i**i
    println(result)
    return result
}.memoize()


def sum1 = 0G
for (i in 0..<100) {
    sum1 += i % 2 == 0 ? bigNumberMemoize(20) : bigNumberMemoize(21)
}


println 'suma 1: ' + sum1