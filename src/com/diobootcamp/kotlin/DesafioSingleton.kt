package com.diobootcamp.kotlin

class User(val id: Int, val name: String)

/*
 * No Kotlin, a declaração de um objeto (por meio da palavra-chave object)
 * é uma maneira concisa e eficaz de implementar o padrão Singleton.
 */
object UserManager {

    private val users = mutableListOf<User>()

    private var quantityUsers = 0;

    fun addUser(name: String) {
        val user = User(++quantityUsers, name);
        users.add(user);
    }

    fun listUsers() {
        for(user in users){
            println("${user.id} - ${user.name}");
        }
    }
}

fun main() {
    val quantity = readLine()?.toIntOrNull() ?: 0

    for (i in 1..quantity) {
        val name = readLine() ?: ""
        UserManager.addUser(name)
    }

    UserManager.listUsers()
}