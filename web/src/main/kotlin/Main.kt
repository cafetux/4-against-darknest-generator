import io.javalin.Javalin
import io.javalin.http.Context

private val generator = RoomEncounterGenerator()

fun main() {
    val app = Javalin.create()
        .get("/dungeon/encounter/generate")
        { ctx: Context -> generateEncounter(ctx) }
        .start(7070)
}

private fun generateEncounter(ctx: Context) {
    val encounter = generator.generate()
    ctx.json(encounter)
}
