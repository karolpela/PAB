package cwicz6

import groovy.json.JsonSlurper

def realNumber = ~/\d+(.\d+)?/

def text = """
    Przykładowy tekst gdzie mamy 3.14 PLN i 5.12 EUR.
    Można też mieć 0 PLN albo 1000 EUR, a nawet 7 PLN.
"""

def realPLN = ~/${realNumber.pattern()} PLN/

def plnList = text.findAll(realPLN)
println(plnList)

def jsonSlurper = new JsonSlurper()
def nbpResponse = jsonSlurper.parse(new URL("https://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json"))

def eurRate = Double.parseDouble((nbpResponse["rates"] as Map)[0]["mid"] as String)

def eurList = plnList*.
        replace(" PLN", "")*.
        toDouble()*.
        div(eurRate as Double)*.
        toDouble()*.
        round(2)*.
        toString()*.
        plus(" EUR")

println(eurList)