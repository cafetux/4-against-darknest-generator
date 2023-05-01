import encounter.Encounter
import enemy.Enemy
import enemy.MajorEnemy
import tornadofx.Controller

class EncounterGeneratorController : Controller() {
    val roomEncounterGenerator = RoomEncounterGenerator()

    fun generate(): EncounterModel {
        val room = roomEncounterGenerator.generate()
        val treasures = room.treasure.map { TreasureModel(it.name, it.details, it.magic) }
        val enemies = room.enemies
        return if (enemies != null) {
            EncounterModel(toRoom(room), toEnemy(enemies), treasures)
        } else {
            EncounterModel(toRoom(room))
        }
    }

    private fun toEnemy(enemies: Enemy): EnemyModel {
        return when (enemies) {
            is MajorEnemy -> MajorEnemyModel(enemies.name, enemies.type.name, enemies.level,enemies.details, enemies.lives)
            else -> MinorEnemyModel(enemies.name, enemies.type.name, enemies.level,enemies.details, enemies.number)
        }
    }

    private fun toRoom(room: Encounter) = RoomModel(room.room.id, room.room.type.name.lowercase())
}