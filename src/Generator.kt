import kotlin.test.assertTrue

@ExperimentalStdlibApi
class Generator private constructor(){
    companion object {

        fun generateGames(teams: List<String>, isDoubleLegged: Boolean = false): List<GameWeek> {
            assertTrue { teams.size %2 == 0 }

            val shuffledTeams = teams.shuffled()
            val games = mutableListOf<GameWeek>().apply {
                add(initWithWeekOneGames(shuffledTeams))
            }

            addRemainingGames(games, shuffledTeams.last(), teams.size)

            return games
        }

        private fun addRemainingGames(games: MutableList<GameWeek>, last: String, teamCount: Int) {
            (2 until teamCount).forEach { week ->
                val gameWeek = GameWeek("Week $week")
                val prevWeekPairings = games.last().getPairingsList().toMutableList()

                if (week % 2 == 0) {
                    gameWeek.addFixture(last, prevWeekPairings.removeLast())
                } else {
                    gameWeek.addFixture(prevWeekPairings.removeLast(), last)
                }
                prevWeekPairings.remove(last)

                while (prevWeekPairings.isNotEmpty()) {
                    val team2 = prevWeekPairings.removeLast()
                    val team1 = prevWeekPairings.removeLast()
                    gameWeek.addFixture(team1, team2)
                }

                games.add(gameWeek)
            }
        }

        private fun initWithWeekOneGames(teams: List<String>): GameWeek {
            var i = 0
            var j = teams.size-1

            val weekOneGames = GameWeek("Week 1")

            while (i < j) {
                weekOneGames.addFixture(teams[i], teams[j])
                i++
                j--
            }

            return weekOneGames
        }
    }
}
