import enemy.Enemy
import room.Room
import treasure.Treasure

data class Encounter(val room: Room, val enemies: Enemy?, val treasure: List<Treasure>) {

    fun isEmpty() : Boolean {
        return enemies == null
    }

    override fun toString(): String {
        return "Encounter(room=$room, enemies=$enemies, treasure=$treasure)"
    }


}