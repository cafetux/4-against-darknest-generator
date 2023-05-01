package view

import RoomModel
import javafx.scene.control.Label
import javafx.scene.text.FontWeight
import tornadofx.*

class RoomView : View() {

    private val roomTitle: Label = label()
    private val roomType: Label = label()

    override val root =
        vbox {
            style {
                backgroundColor += c("#fefefe")
                borderColor += box(c("#222222"))
                minWidth = 200.px
                padding = box(5.px)
            }
            label("Pièce") {
                style {
                    fontWeight = FontWeight.BOLD
                }
            }

            hbox {
                label("id: ")
                add(roomTitle)
            }
            hbox {
                label("Type: ")
                add(roomType)
            }
        }

    fun update(room: RoomModel) {
        roomTitle.text = room.roomId.toString()
        roomType.text = room.roomType
    }
}
