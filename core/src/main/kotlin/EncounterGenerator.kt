import enemy.Enemy
import enemy.generator.getBoss
import enemy.generator.getDragon
import enemy.generator.getStrangeMonsters
import enemy.getNuisibles
import enemy.getSbires
import room.Room
import room.RoomType
import room.RoomType.CORRIDOR
import room.RoomType.LARGE_ROOM
import treasure.generateTreasure

class EncounterGenerator {


    fun generate(room: Room, diceResult: Int): Encounter {

        val enemies: Enemy? = when {
            diceResult == 6 -> getNuisibles()
            diceResult == 7 -> getSbires()
            diceResult == 8 && room.type == LARGE_ROOM -> getSbires()
            diceResult == 10 && room.type == LARGE_ROOM -> getStrangeMonsters()
            diceResult == 11 -> getBoss()
            diceResult == 12 && room.type == LARGE_ROOM -> getDragon()
            else -> null
        }

        return if(enemies == null) {
            Encounter(room, null, listOf())
        } else {
            Encounter(room, enemies, generateTreasure(enemies.treasure))
        }
    }

}