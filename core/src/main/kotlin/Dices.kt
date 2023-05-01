import kotlin.random.Random

enum class Dices {

    D6 {
        override fun roll(): Int {
            return roll(6)
        }
    },
    D66 {
        override fun roll(): Int {
            return ("${D6.roll()}${D6.roll()}").toInt()
        }
    },
    DeuxD6 {
        override fun roll(): Int {
            return D6.roll() + D6.roll();
        }
    },
    TroisD6 {
        override fun roll(): Int {
            return D6.roll() + D6.roll() + D6.roll();
        }
    },
    D6xD6 {
        override fun roll(): Int {
            return D6.roll() * D6.roll();
        }
    },
    D3 {
        override fun roll(): Int {
            return roll(3);
        }


    };

    internal fun roll(nbFaces: Int) = Random.nextInt(nbFaces) + 1

    abstract fun roll(): Int
}