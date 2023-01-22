package cwicz7

import groovy.io.FileType

def input = new File('./data/html')
def i = 1
input.eachFileRecurse(FileType.FILES, {
    if (it.toString().endsWith(".html")) {
        println "${i++} ${it}"
    }
})