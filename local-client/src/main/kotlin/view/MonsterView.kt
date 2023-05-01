package view

import EnemyModel
import MajorEnemyModel
import MinorEnemyModel
import javafx.scene.control.Label
import javafx.scene.text.FontWeight
import tornadofx.*

class MonsterView : View() {

    val enemyName: Label = label()
    val enemyType: Label = label()
    val enemyLevel: Label = label()
    val enemyLives: Label = label()
    var majorBlock = hbox { }
    val enemyDetails: Label = label()

    override val root =
        vbox {
            style {
                backgroundColor += c("#fefefe")
                borderColor += box(c("#222222"))
                minWidth = 200.px
                padding = box(5.px)
            }
            label("Monstre") {
                style {
                    fontWeight = FontWeight.BOLD
                }
            }
            hbox {
                label("Nom: ")
                add(enemyName)
            }
            hbox {
                label("Type: ")
                add(enemyType)
            }
            hbox {
                label("Niveau: ")
                add(enemyLevel)
            }
            majorBlock = hbox {
                label("PV: ")
                add(enemyLives)
            }
            hbox {
                label("Détails: ") {
                    style {
                        fontSize = 20.px
                    }
                }
                style {
                    fontSize = 13.px
                }
                add(enemyDetails)
            }
        }

    fun update(enemy: EnemyModel?) {
        when (enemy) {
            is MinorEnemyModel -> {
                enemyName.text = "${enemy.count} ${enemy.name}"
                enemyType.text = enemy.type
                enemyLevel.text = enemy.level.toString()
                enemyDetails.text = format(enemy.details)
                majorBlock.isVisible = false
            }
            is MajorEnemyModel -> {
                enemyName.text = enemy.name
                enemyType.text = enemy.type
                enemyLevel.text = enemy.level.toString()
                enemyLives.text = enemy.lives.toString()
                enemyDetails.text = format(enemy.details)
                majorBlock.isVisible = true
            }
            else -> {
                enemyName.text = "Aucun"
                enemyType.text = ""
                enemyLevel.text = ""
                enemyLives.text = ""
                enemyDetails.text = ""
                majorBlock.isVisible = false

            }
        }
    }

    private fun format(details: List<String>): String {
        return if(details.isEmpty()) {
            ""
        } else {
             "\n -"+details.joinToString("\n -")
        }
    }
}
