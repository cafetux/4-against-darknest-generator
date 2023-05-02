import encounter.Encounter
import enemy.Enemy
import enemy.MajorEnemy
import tornadofx.Controller
import trap.Trap

class EncounterGeneratorController : Controller() {
    val roomEncounterGenerator = RoomEncounterGenerator()

    fun generate(): EncounterModel {
        val room = roomEncounterGenerator.generate()
        val treasures = room.treasure.map { TreasureModel(it.name, it.details, it.magic) }
        val enemies = room.enemies
        return if (enemies != null) {
            EncounterModel(toRoom(room), toEnemy(enemies), treasures)
        } else {
            EncounterModel(toRoom(room),null, treasures, trap(room.trap))
        }
    }

    private fun trap(trap: Trap?): TrapModel? {
        return trap?.let { TrapModel(it.name, trap.level, trap.description) }
    }

    private fun toEnemy(enemies: Enemy): EnemyModel {
        return when (enemies) {
            is MajorEnemy -> MajorEnemyModel(
                enemies.name,
                enemies.type.name,
                enemies.level,
                enemies.details,
                enemies.lives,
                enemies.reaction
            )
            else -> MinorEnemyModel(enemies.name, enemies.type.name, enemies.level,enemies.details, enemies.number, enemies.reaction)
        }
    }

    private fun toRoom(room: Encounter) = RoomModel(room.room.id, room.room.type.name.lowercase())
}