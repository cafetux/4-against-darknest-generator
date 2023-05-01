package enemy

import treasure.TreasureType

open class Enemy(
    val type: EnemyType, val number: Int, val level: Int, val undead: Boolean, val bonusEcrasant: Boolean, val name: String,
    val details: List<String>, val treasure: TreasureType, val reactions: List<String>
) {

    override fun toString(): String {
        return "Enemy(type=$type, number=$number, level=$level, name='$name')"
    }
}