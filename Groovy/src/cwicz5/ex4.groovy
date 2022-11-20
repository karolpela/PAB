package cwicz5

import javax.swing.JOptionPane

def items = [:]

while (true) {
    def input = JOptionPane.showInputDialog('Input as "item = price"')
    if (input == null)
        break

    def item = input.split(" = ")
    if (item.length != 2) {
        JOptionPane.showMessageDialog(null, "Improper input")
        continue
    }

    def name = item[0]
    def price = item[1]
    if (price.isNumber()) {
        items.merge(name, price.toInteger(), Integer::sum)
    } else {
        JOptionPane.showMessageDialog(null, "Price must be a number")
    }
}

println(items)