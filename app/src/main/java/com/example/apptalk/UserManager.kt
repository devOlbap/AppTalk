package com.example.apptalk

object UserManager {
    private val users = mutableListOf(
        User("admin@gmail.com", "admin123", "admin", 1),
        User("pauli@gmail.com", "pauli123", "pauli", 2),
        User("olbap@gmail.com", "olbap123", "olbap", 3)
    )


    private var user_log: User = User()

    fun setUserLog(user:User){
        user_log = user
    }
    fun getUserLog():User{
        return user_log
    }

    fun getUsers(): List<User> {
        return users
    }

    fun addUser(email: String, password: String, username: String, id : Int) {
        val newUser = User(email, password, username, id)
        users.add(newUser)
    }

    fun findUser(email: String, password: String): User? {
        return users.find { it.email == email && it.password == password }
    }

    fun getCountUsers():Int{
        return users.size
    }

    fun delUserLog(){
        user_log = User()
    }

}

data class User(
    val email: String ="",
    val password: String="",
    val username: String="",
    val id: Int =0
)
