data class GameWeek(
    val name: String,
    val fixtures: MutableList<Fixture> = mutableListOf()
) {
    override fun toString(): String {
        return "\n$name\n$fixtures\n"
    }
}

fun GameWeek.getPairingsList(): List<String> {
    return fixtures
        .map { listOf(it.teamA, it.teamB) }
        .flatten()
}

fun GameWeek.addFixture(teamA: String, teamB: String) = fixtures.add(Fixture(teamA, teamB))
