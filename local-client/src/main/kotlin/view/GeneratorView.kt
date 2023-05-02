package view

import EncounterGeneratorController
import javafx.geometry.Pos
import tornadofx.*

class GeneratorView : View("Dungeon Room") {

    val controller: EncounterGeneratorController by inject()
    val roomView = find<RoomView>()
    val monsterView = find<MonsterView>()
    val treasureView = find<TreasureView>()
    val trapView = find<TrapView>()

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

                    center = vbox {
                        add(monsterView.root)
                        add(trapView.root)
                    }

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
                            if (result.enemy == null) {
                                treasureView.show()
                            }
                            trapView.update(result.trap)
                        }
                    }
                }
            }
        }
    }
}