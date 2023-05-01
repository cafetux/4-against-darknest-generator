package view

import EncounterGeneratorController
import javafx.geometry.Pos
import tornadofx.*

class GeneratorView : View("Dungeon Room") {

    val controller: EncounterGeneratorController by inject()
    val roomView = find<RoomView>()
    val monsterView = find<MonsterView>()
    val treasureView = find<TreasureView>()

    override val root = vbox {
        style {
            minWidth = 1000.px
            minHeight = 800.px
            padding = box(10.px)
            fontSize = 20.px

            borderpane {

                top = hbox {
                    label("Rencontre")
                    alignment = Pos.CENTER
                }


                center = borderpane {

                    top = roomView.root

                    center = monsterView.root

                    bottom = treasureView.root

                }
                bottom = hbox {
                    alignment = Pos.BOTTOM_CENTER
                    button("Générer") {
                        action {
                            val result = controller.generate()
                            roomView.update(result.room)
                            monsterView.update(result.enemy)
                            treasureView.update(result.treasures)
                        }
                    }
                }
            }
        }
    }
}