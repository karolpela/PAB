package cwicz8

import javax.swing.*

def list = JOptionPane.showInputDialog("Input space-separated numbers")
        .split(" ")
        *.toInteger()

def descending = new Comparator<Integer>() {
    @Override
    int compare(Integer o1, Integer o2) {
        return o2 - o1
    }
}

list.sort(descending)
println list
Collections.reverse(list)
println list