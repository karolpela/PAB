package cwicz8

import java.text.Collator

def locale = new Locale("pl")
def collator = Collator.getInstance(locale)

def words = new TreeMap(collator)

def baseDir = System.getProperty("user.dir")
def input = new File(baseDir, '/data/Polski.txt')
input.splitEachLine(~/(?i)[^\wąęźżółń]|\d+/, "utf-8") {
    it*.toLowerCase()
            .findAll { it != "" }
            .each {
                word -> words[word] = ++words.get(word, 0)
            }
}

words.each { println(it) }