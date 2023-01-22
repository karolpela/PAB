package cwicz9

import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

swing = new SwingBuilder()

def laymans = [new BorderLayout(),
               new FlowLayout(),
               new FlowLayout(FlowLayout.LEFT),
               new FlowLayout(FlowLayout.RIGHT),
               new GridLayout(1, 0),
               new GridLayout(0, 1),
               new GridLayout(3, 2)]

swing.edt {
    def opt = JOptionPane.showInputDialog('Choose from 0-6').toInteger()
    frame(layout: laymans[opt],
            locationRelativeTo: null,
            title: "Buttons",
            pack: true,
            visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        button(text: 'Przycisk 1', constraints: BorderLayout.PAGE_START)
        button(text: 'Przycisk 2', constraints: BorderLayout.LINE_START)
        button(text: 'Przycisk 3', constraints: BorderLayout.CENTER)
        button(text: 'Przycisk 4', constraints: BorderLayout.LINE_END)
        button(text: 'Przycisk 5', constraints: BorderLayout.PAGE_END)
    }
}