import io.javalin.Javalin
import io.javalin.http.Context
import room.Rooms

val rooms = Rooms()
val encounterGenerator = EncounterGenerator()

fun main() {
    val app = Javalin.create()
        .get("/dungeon/encounter/generate")
        { ctx: Context -> generateEncounter(ctx) }
        .start(7070)
}

private fun generateEncounter(ctx: Context) {
    val encounter = encounterGenerator.generate(rooms.generateRoom(), Dices.DeuxD6.roll())
    ctx.json(encounter)
}
