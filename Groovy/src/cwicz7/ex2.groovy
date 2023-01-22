package cwicz7

import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def nbpResponse = jsonSlurper.parse(new URL("https://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json"))
def eurRate = Double.parseDouble((nbpResponse["rates"] as Map)[0]["mid"] as String)

def input = new File('./data/MenuPL.txt')
def output = new File('./out/MenuEUR.txt')
output.write("")
input.splitEachLine(" ") {
    def name = it[0]
    def pricePln = Double.parseDouble(it[1])
    def priceEur = (pricePln / eurRate).round(2)
    output << "${name} ${priceEur}\n"
}