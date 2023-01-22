package cwicz8

import javax.swing.*

println JOptionPane.showInputDialog("Input space-separated numbers")
        .split(" ")
        *.toInteger()
        .collect { 2 * it }