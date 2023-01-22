package cwicz8

import javax.swing.*

def list = JOptionPane.showInputDialog("Input space-separated numbers")
        .split(" ")
        *.toInteger()
println list.sort()
println list.findAll { it < 0 }