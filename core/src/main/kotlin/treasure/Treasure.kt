package treasure

data class Treasure(val name: String, val details: String, val magic : Boolean = false) {

    override fun toString(): String {
        return "Treasure(name='$name', details='$details', magic=$magic)"
    }
}