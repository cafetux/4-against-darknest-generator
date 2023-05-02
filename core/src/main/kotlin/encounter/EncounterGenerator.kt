package encounter

import enemy.Enemy
import enemy.generator.getBoss
import enemy.generator.getDragon
import enemy.generator.getStrangeMonsters
import enemy.getNuisibles
import enemy.getSbires
import room.Room
import room.RoomType.LARGE_ROOM
import trap.Trap
import trap.generateTrap
import treasure.Treasure
import treasure.TreasureType
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
            val treasures = when(diceResult) {
                2, 3 -> generateTreasure(TreasureType.NORMAL)
                else -> listOf()
            }
            Encounter(room, treasures,null, trap(diceResult))
        } else {
            Encounter(room, generateTreasure(enemies.treasure), enemies)
        }
    }

    private fun trap(diceResult: Int): Trap? {
        return when(diceResult) {
            3 -> generateTrap()
            else -> null
        }
    }

}