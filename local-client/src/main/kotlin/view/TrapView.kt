package view

import TrapModel
import TreasureModel
import javafx.beans.property.ReadOnlyListProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.text.FontWeight
import tornadofx.*
import trap.Trap

class TrapView : View() {


    private val trapName: Label = label()
    private val trapLevel: Label = label()
    private val trapDetails: Label = label()

    override val root =
        vbox {
            style {
                backgroundColor += c("#fefefe")
                borderColor += box(c("#222222"))
                minWidth = 200.px
                padding = box(5.px)
                fontSize = 15.px
            }
            hbox {
                label("Piège") {
                    style {
                        fontSize = 20.px
                        fontWeight = FontWeight.BOLD
                    }
                }

            }
            hbox {
                add(trapName)
            }
            hbox {
                label("Niveau: ")
                add(trapLevel)
            }
            hbox {
                label("Détails: ")
                add(trapDetails)
            }


        }

    fun update(trap: TrapModel?) {
        if(trap == null) {
            this.root.hide()
        } else {
            this.root.show()
            this.trapName.text = trap.name
            this.trapLevel.text = trap.level.toString()
            this.trapDetails.text = trap.details.joinToString { "\n - $it" }
        }
    }
}
