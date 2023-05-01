package enemy

enum class EnemyType(private val major: Boolean) {
    NUISIBLES(false),
    SBIRES(false),
    STRANGE(true),
    BOSS(true);

}