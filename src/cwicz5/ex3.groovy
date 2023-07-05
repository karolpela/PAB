package cwicz5

static String join(List l, String sep) {
    //return l.join(sep);
    def result = ""
    l.forEach(s -> result += s + sep)
    return result.trim()
}

println join(["a", "a", "a", "a", "a"], "")