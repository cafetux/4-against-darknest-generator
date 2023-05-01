data class EncounterModel(val room: RoomModel, val enemy: EnemyModel? = null, val treasures: List<TreasureModel> = emptyList())
data class RoomModel(val roomId: Int, val roomType: String)

open class EnemyModel(val name: String, val type: String, val level: Int, val details: List<String>)
class MajorEnemyModel(name: String,type: String, level: Int, details: List<String>, val lives: Int) : EnemyModel(name, type, level, details)
class MinorEnemyModel(name: String,type: String, level: Int,  details: List<String>, val count: Int) : EnemyModel(name, type, level, details)

data class TreasureModel(val name: String, val description: String, val isMagic: Boolean)