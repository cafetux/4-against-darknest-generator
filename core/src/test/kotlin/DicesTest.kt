import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import room.Rooms

class DicesTest {

    val roomGenerator = Rooms()

    @Test
    fun should_D6_generate_number_between_1_and_6_inclusive() {
        var values = listOf(1, 2, 3, 4, 5, 6)
        for (i in 0..30) {
            val roll = Dices.D6.roll()
            assertThat(roll)
                .isGreaterThan(0)
                .isLessThan(7)
            values = values.filter { x -> x != roll }
        }
        assertThat(values).`as`("should take all values of d6 dices").isEmpty();
    }

    @Test
    fun should_D66_generate_number_from_11_to_66_but_never_x0_x7_x8_or_x9() {
        for (i in 0..30) {
            assertThat(Dices.D66.roll())
                .isGreaterThan(10)
                .isLessThan(67)
                .isNotIn(17, 18, 19, 20, 27, 28, 29, 30, 37, 38, 39, 40, 47, 48, 49, 50, 57, 58, 59, 60, 67, 68, 69);
        }
    }

    @Test
    fun should_2D6_generate_number_between_2_and_12_inclusive() {
        var values = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        for (i in 0..200) {
            val roll = Dices.DeuxD6.roll()
            assertThat(roll)
                .isGreaterThan(1)
                .isLessThan(13)
            values = values.filter { x -> x != roll }
        }
        assertThat(values).`as`("should take all values of 2d6 dices").isEmpty();
    }

    @Test
    fun should_D6D6_generate_number_between_1_and_36_inclusive() {
        var values = listOf(1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25, 30, 36)
        for (i in 0..1000) {
            val roll = Dices.D6xD6.roll()
            assertThat(roll)
                .isGreaterThan(0)
                .isLessThan(37)
            values = values.filter { x -> x != roll }
        }
        assertThat(values).`as`("should take all values of 2d6 dices").isEmpty();
    }

}