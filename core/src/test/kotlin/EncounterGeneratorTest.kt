import encounter.EncounterGenerator
import enemy.EnemyType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import room.Room
import room.RoomType
import room.RoomType.CORRIDOR
import room.RoomType.LARGE_ROOM

class EncounterGeneratorTest {

    val generator: EncounterGenerator = EncounterGenerator()


    @Test
    fun should_not_find_enemies_when_some_values() {

        for (type in listOf(CORRIDOR, LARGE_ROOM)) {
            for (diceRoll in listOf(2, 3, 4, 5, 9)) {
                val result = generator.generate(room(type), diceRoll)
                assertThat(result.enemies).`as`("should not has enemies for dice $diceRoll on $type").isNull()
            }
        }
    }
    @Test
    fun should_not_find_treasure_without_enemies_when_some_values() {

        for (type in listOf(CORRIDOR, LARGE_ROOM)) {
            for (diceRoll in listOf(2, 3)) {
                val result = generator.generate(room(type), diceRoll)
                assertThat(result.enemies).`as`("should not has enemies for dice $diceRoll on $type").isNull()
                assertThat(result.treasure).`as`("should has treasure for dice $diceRoll on $type").isNotNull()
            }
        }
    }

    @Test
    fun should_find_sbires_when_7() {

        for (type in listOf(CORRIDOR, LARGE_ROOM)) {
            val result = generator.generate(room(type), 7)
            assertThat(result.enemies).`as`("should find enemies").isNotNull()
            assertThat(result.enemies?.type)
                .`as`("should find enemies of type sbires")
                .isEqualTo(EnemyType.SBIRES)
        }
    }

    @Test
    fun should_find_nuisibles_when_6() {

        for (type in listOf(CORRIDOR, LARGE_ROOM)) {
            val result = generator.generate(room(type), 6)
            assertThat(result.enemies).`as`("should find enemies").isNotNull
            assertThat(result.enemies?.type)
                .`as`("should find enemies of type nuisibles")
                .isEqualTo(EnemyType.NUISIBLES)
        }
    }

    @Test
    fun should_find_sbires_when_8_on_large_room() {

        var result = generator.generate(room(LARGE_ROOM), 8)

        assertThat(result.enemies).`as`("should find enemies").isNotNull
        assertThat(result.enemies?.type)
            .`as`("should find enemies of type sbires")
            .isEqualTo(EnemyType.SBIRES)


        result = generator.generate(room(CORRIDOR), 8)

        assertThat(result.enemies).`as`("should not find enemies on corridor").isNull()
    }

    @Test
    fun should_find_strange_monster_when_10_on_large_room() {

        var result = generator.generate(room(LARGE_ROOM), 10)

        assertThat(result.enemies).`as`("should find enemies").isNotNull
        assertThat(result.enemies?.type)
            .`as`("should find enemies of type stranges")
            .isEqualTo(EnemyType.STRANGE)

        result = generator.generate(room(CORRIDOR), 8)

        assertThat(result.enemies).`as`("should find enemies").isNull()
    }

    @Test
    fun should_find_boss_when_11() {

        for (type in listOf(CORRIDOR, LARGE_ROOM)) {
            val result = generator.generate(room(type), 11)

            assertThat(result.enemies).`as`("should find enemies").isNotNull

            assertThat(result.enemies?.type)
                .`as`("should find enemies of type nuisibles")
                .isEqualTo(EnemyType.BOSS)

            assertThat(result.enemies?.name)
                .`as`("should not be a dragon")
                .doesNotContain("dragon")

        }
    }

    @Test
    fun should_find_little_dragon_when_12_on_large_room() {

        var result = generator.generate(room(LARGE_ROOM), 12)

        assertThat(result.enemies).`as`("should find enemies").isNotNull

        assertThat(result.enemies?.type)
            .`as`("should find enemies of type nuisibles")
            .isEqualTo(EnemyType.BOSS)

        assertThat(result.enemies?.name)
            .`as`("should not be a dragon")
            .contains("dragon")

        result = generator.generate(room(CORRIDOR), 12)

        assertThat(result.enemies).`as`("should not find enemies").isNull()
    }

    @Test
    fun should_find_special_event_on_large_room_when_4() {

        val result = generator.generate(room(LARGE_ROOM), 4)

        assertThat(result.enemies).`as`("should not hae enemies").isNull()
    }

    private fun room(roomType: RoomType) = Room(12, roomType)
}
