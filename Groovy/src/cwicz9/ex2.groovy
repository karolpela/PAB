package cwicz9

import groovy.swing.SwingBuilder

import java.awt.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

swing = new SwingBuilder()

def colors = [Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK]
def iter = colors.iterator()

swing.edt {
    frame(title: "Colorful button",
            pack: true,
            visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        button(text: "Change color",
                preferredSize: new Dimension(200, 200),
                actionPerformed: { e ->
                    e.source.background = iter.next()
                    if (!iter.hasNext()) {
                        iter = colors.iterator()
                    }
                })
    }
}