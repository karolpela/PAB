package cwicz8

import javax.swing.*

def words = new URL(
        "http://wiki.puzzlers.org/pub/wordlists/unixdict.txt").readLines()
def anagrams = [:].withDefault { [] }
words.each { word ->
    def anagram = toAnagram(word)
    anagrams[anagram] << word
}

anagrams.values()
        .toSorted {
            Comparator.comparing(
                    List::size,
                    Comparator.reverseOrder())
        }
        .each {
            values ->
                values.each {
                    word -> println "${word}  =>  ${values}"
                }
        }

// dialog

while (true) {
    def input = JOptionPane.showInputDialog('Input a word')
    if (input == null) { // "Cancel"
        return
    }
    JOptionPane.showMessageDialog(null, anagrams[
            toAnagram(input)
    ].toSorted { Comparator.naturalOrder() })
}


static String toAnagram(String word) {
    return word.chars
            .toList()
            .toSorted()
            .join()
}
