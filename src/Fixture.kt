data class Fixture(
    val teamA: String,
    val teamB: String,
    val result: Pair<Int, Int> = Pair(0,0)
) {
    override fun toString(): String {
        return "$teamA vs $teamB"
    }
}

fun Fixture.hasTeam(team: String) = teamA == team || teamB == team