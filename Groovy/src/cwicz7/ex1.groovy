package cwicz7


import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson

def input = new File('./data/Projekty.txt')
def programmers = [:].withDefault { [] }
def projects = [:].withDefault { [] }
//noinspection GroovyMissingReturnStatement
input.splitEachLine('\t') {
    def project = it[0]

    if (it.size() !== 1) {
        return
    }

    def participants = it[1..-1]
    participants.removeAll("")
    participants.each { p ->
        programmers[p].add(project)
    }

    if (participants.size() > 3) {
        projects[project].addAll(participants)
    }
}

def projectsOutput = new File(baseDir, 'out/ProjektyDuze.txt')
projectsOutput.write(prettyPrint(toJson(projects)))
def programmersOutput = new File(baseDir, 'out/Programisci.txt')
programmersOutput.write(prettyPrint(toJson(programmers)))

