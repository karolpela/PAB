//file:noinspection GroovyUnusedCatchParameter
package cwicz6

import java.time.LocalDate

def text = "3000-63-42 0000-00-00 There are no extended formats for century, year or year/month, but there are for the other formats. Additionally, all formats -- basic and extended -- must include the exact number of digits specified by the ISO standard. For example, April 6, 2022 should be specified as 20220406 or 2022-04-06, rather than 202246 or 2022-4-6."

def dates = (text =~ /\d{4}-\d{2}-\d{2}/).findAll { String date ->
    try {
        LocalDate.parse(date, "yyyy-MM-dd")
        return true
    } catch (DateTimeParseException) {
        return false
    }
}

println dates