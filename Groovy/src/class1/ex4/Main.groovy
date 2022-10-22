package class1.ex4

def numbersToWords =
        [1: "jeden",
         2: "dwa",
         3: "trzy",
         4: "cztery",
         5: "pięć",
         6: "sześć",
         7: "siedem",
         8: "osiem",
         9: "dziewięć"]
print "Enter a number: "
def input = System.in.newReader().readLine()

if (input.isNumber()) {
    def numbers = input.getChars()
            .collect { Character.getNumericValue(it) }
    def words = numbers.collect { numbersToWords[it] }
    println words.join(" - ")
}