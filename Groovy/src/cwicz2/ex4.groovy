package cwicz2

import javax.swing.JOptionPane

println getData(Integer) { it > 0 }     // liczby całkowite większe od 0
println getData() { it.size() > 3 }   // słowa o długości większej od 3 (domyślny typ: String)
println getData()                    // dowolne napisy (słowa)
println getData(BigDecimal)         // dowolne liczby

def static getData(Class type = String) {
    def items
    def output = new ArrayList()

    while (true) {
        def input = JOptionPane.showInputDialog('Input comma-separated texts')
        if (input == null) { // "Cancel"
            return
        }
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be blank")
            continue
        }

        items = input.split(",")

        if (type == Integer) {
            if (items.any { !it.isInteger() }) {
                JOptionPane.showMessageDialog(null, "Please input only integers")
                continue
            }
            output.addAll(items.collect { it as Integer })
        } else if (type == BigDecimal) {
            if (items.any { !it.isBigDecimal() }) {
                JOptionPane.showMessageDialog(null, "Please input only big decimals")
                continue
            }
            output.addAll(items.collect { it as BigDecimal })
        } else {
            output = items
        }
        break
    }
    return output
}

def static getData(Closure c) {
    def items

    while (true) {
        def input = JOptionPane.showInputDialog('Input comma-separated texts')
        if (input == null) { // "Cancel"
            return
        }
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be blank")
            continue
        }

        items = input.split(",")

        break
    }

    return items.findAll(c)
}

def static getData(Class type, Closure c) {
    def items
    def output = new ArrayList()

    while (true) {
        def input = JOptionPane.showInputDialog('Input comma-separated texts')
        if (input == null) { // "Cancel"
            return
        }
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be blank")
            continue
        }

        items = input.split(",")

        if (type == Integer) {
            if (items.any { !it.isInteger() }) {
                JOptionPane.showMessageDialog(null, "Please input only integers")
                continue
            }
            output.addAll(items.collect { it as Integer })
        } else if (type == BigDecimal) {
            if (items.any { !it.isBigDecimal() }) {
                JOptionPane.showMessageDialog(null, "Please input only big decimals")
                continue
            }
            output.addAll(items.collect { it as BigDecimal })
        }

        break
    }

    return output.findAll(c)
}