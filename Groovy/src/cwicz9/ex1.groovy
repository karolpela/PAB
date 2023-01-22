//file:noinspection GroovyAssignabilityCheck
package cwicz9

import groovy.beans.Bindable
import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

swing = new SwingBuilder()

class editorProperties {
    @Bindable
    String fontName,
           fontSize,
           fgColor,
           bgColor
}

def ep = new editorProperties()

swing.edt {
    frame(id: 'editor', title: "Prosty edytor", pack: true,
            visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        JOptionPane.showMessageDialog(null,
                panel() {
                    label(text: 'Font name')
                    textField(id: 'fnt', columns: 20,)
                    label(text: 'Font size')
                    textField(id: 'fst', columns: 20,)
                    label(text: 'Text color')
                    textField(id: 'fgt', columns: 20,)
                    label(text: 'Background color')
                    textField(id: 'bgt', columns: 20,)
                    bean(ep,
                            fontName: bind { fnt.text },
                            fontSize: bind { fst.text },
                            fgColor: bind { fgt.text },
                            bgColor: bind { bgt.text })

                })
        textArea(rows: 20,
                columns: 50,
                font: new Font(ep.fontName, Font.PLAIN, ep.fontSize.toInteger()),
                foreground: (Color) Color.class.getField(ep.fgColor.toUpperCase()).get(),
                background: (Color) Color.class.getField(ep.bgColor.toUpperCase()).get(),
        )
    }
}


