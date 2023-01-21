package cwicz7

import groovy.io.FileType

def baseDir = System.getProperty("user.dir")
def input = new File(baseDir,'/data/html')
def i = 1
input.eachFileRecurse(FileType.FILES,{
    if (it.toString().endsWith(".html")) {
        println "${i++} ${it}"
    }
})