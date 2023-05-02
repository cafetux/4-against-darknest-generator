package encounter

import enemy.Enemy
import room.Room
import trap.Trap
import treasure.Treasure

data class Encounter(val room: Room, val treasure: List<Treasure>, val enemies: Enemy? = null, val trap : Trap? = null) {

    fun isEmpty() : Boolean {
        return enemies == null
    }

    override fun toString(): String {
        return "encounter.Encounter(room=$room, enemies=$enemies, treasure=$treasure, trap=$trap)"
    }


}