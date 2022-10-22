package class2.ex2

import javax.swing.JOptionPane

print getInts()

def static getInts() {
    def items
    while (true) {
        def input = JOptionPane.showInputDialog('Input comma-separated integers')
        if (input == null) { // "Cancel"
            return
        }
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be blank")
            continue
        }

        items = input.split(",")

        if (items.any { !it.isInteger() }) {
            JOptionPane.showMessageDialog(null, "Please input only integers")
            continue
        }
        break
    }
    return items.collect { it as Integer }
}

