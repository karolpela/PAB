package cwicz8


import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson

def comparator = new Comparator<String>() {
    @Override
    int compare(String o1, String o2) {
        if (o1.size() != o2.size()) {
            return o1.size() - o2.size()
        } else {
            o1.compareToIgnoreCase(o2)
        }
    }
}
def words = new TreeSet(comparator)

def baseDir = System.getProperty("user.dir")
def input = new File(baseDir, '/data/Lorem.txt')
input.splitEachLine(" ") { List<String> line ->
    def cleanedUp = line.collect {
        it.endsWithAny(',', '.') ? // remove punctuation
                it[0..-2] :
                it
    }
    words.addAll(cleanedUp)
}

println(prettyPrint(toJson(words)))