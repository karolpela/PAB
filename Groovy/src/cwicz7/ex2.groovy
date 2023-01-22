package cwicz7

import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def nbpResponse = jsonSlurper.parse(new URL("https://api.nbp.pl/api/exchangerates/rates/A/EUR?format=json"))
def eurRate = Double.parseDouble((nbpResponse["rates"] as Map)[0]["mid"] as String)

def baseDir = System.getProperty("user.dir")
def input = new File(baseDir, '/data/MenuPL.txt')
def output = new File(baseDir, '/out/MenuEN.txt')
output.write("")
input.splitEachLine(" ") {
    def name = it[0]
    def pricePln = Double.parseDouble(it[1])
    def priceEur = (pricePln / eurRate).round(2)
    output << "${name} ${priceEur}\n"
}