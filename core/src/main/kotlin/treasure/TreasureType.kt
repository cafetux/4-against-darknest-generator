package treasure

data class TreasureType(val nb: Int, val moderation: Int) {
    companion object {
        val NORMAL = TreasureType(1, 0)
        val NONE = TreasureType(0, 0)
    }
}