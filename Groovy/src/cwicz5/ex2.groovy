package cwicz5

static String reverseWords(String s) {
    return s.tokenize()[-1..0].join(" ")
}

print reverseWords("ala ma kota")
