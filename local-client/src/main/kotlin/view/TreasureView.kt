package view

import TreasureModel
import javafx.beans.property.ReadOnlyListProperty
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.text.FontWeight
import tornadofx.*

class TreasureView : View() {


    private val treasures: Label = label()
    private val showTreasures : Button = button()

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
                label("Trésors") {
                    style {
                        fontSize = 20.px
                        fontWeight = FontWeight.BOLD
                    }
                }
                button("Montrer") {
                    action {
                        treasures.isVisible = true
                    }
                }
            }
            add(treasures)

        }

    fun update(treasures: List<TreasureModel>) {
        if(treasures.isEmpty()) {
            this.treasures.text = "Aucun"
            this.showTreasures.isVisible = false
        } else {
            this.treasures.isVisible = false
            this.treasures.text = treasures.joinToString { "\n -${it.name}:${it.description} (magique:${it.isMagic})" }
        }
    }
}
