@ExperimentalStdlibApi
fun main(args: Array<String>) {
    val teams = (1..4)
        .map { "Team $it" }

    val games = Generator.generateGames(teams)
    println(games)
}