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
    reactions: List<String>,
    val lives: Int,
    val nbAttaques: Int
) : Enemy(type, 1, level, undead, bonusEcrasant, name, details, treasure, reactions) {

    override fun toString(): String {
        return "MajorEnemy(lives=$lives, nbAttaques=$nbAttaques, ${super.toString()} )"
    }
}