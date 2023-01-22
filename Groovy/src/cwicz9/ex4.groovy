package cwicz9

import groovy.io.FileType
import groovy.swing.SwingBuilder

import javax.swing.*
import java.awt.*

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

swing = new SwingBuilder()

swing.edt {
    //noinspection GroovyAssignabilityCheck
    def dir = null
    fc = fileChooser(
            currentDirectory: new File("."),
            fileSelectionMode: JFileChooser.DIRECTORIES_ONLY
    )
    if (fc.showOpenDialog() == JFileChooser.APPROVE_OPTION) {
        dir = fc.selectedFile
    }
    if (dir == null) return

    def images = []
    dir.eachFileMatch(FileType.FILES, ~/.*\.((png)|(jpg))/, {
        images << it
    })
    if (images.size() == 0) return

    def imageIter = images.iterator()

    //noinspection GroovyAssignabilityCheck
    frame(locationRelativeTo: null,
            size: [500, 500],
            title: "Images",
            visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        l = label(
                icon: imageIcon(file: imageIter.next()),
                horizontalAlignment: JLabel.CENTER,
                constraints: BorderLayout.CENTER
        )
        button(text: 'Next',
                actionPerformed: {
                    l.setIcon(imageIcon(file: imageIter.next()))
                    if (!imageIter.hasNext()) {
                        imageIter = images.iterator()
                    }
                },
                constraints: BorderLayout.PAGE_END
        )
    }
}