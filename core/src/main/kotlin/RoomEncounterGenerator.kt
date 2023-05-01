import encounter.Encounter
import encounter.EncounterGenerator
import room.Rooms

class RoomEncounterGenerator {

    private val encounterGenerator = EncounterGenerator()

    private val rooms = Rooms()

    fun generate() : Encounter {
        return encounterGenerator.generate(rooms.generateRoom(), Dices.DeuxD6.roll())
    }
}