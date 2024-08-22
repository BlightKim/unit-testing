package chapter5

class Controller(
    private val emailGateway: IEmailGateway? = null,
    private val database: IDatabase? = null
) {
    fun greetUser(userEmail: String) {
        emailGateway?.sendGreetingsEmail(userEmail)
    }

    fun createReport(): Report {
        val numberOfUsers = database?.getNumberOfUsers() ?: 0
        return Report(numberOfUsers)
    }
}
