package enemy

import treasure.TreasureType

class MajorEnemy(
    type: EnemyType,
    level: Int,
    undead: Boolean,
    bonusEcrasant: Boolean,
    name: String,
    details: List<String>,
    treasure: TreasureType,
    reaction: String,
    val lives: Int,
    val nbAttaques: Int
) : Enemy(type, 1, level, undead, bonusEcrasant, name, details, treasure, reaction) {

    override fun toString(): String {
        return "MajorEnemy(lives=$lives, nbAttaques=$nbAttaques, ${super.toString()} )"
    }
}