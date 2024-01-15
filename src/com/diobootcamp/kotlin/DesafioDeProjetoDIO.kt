package com.diobootcamp.kotlin

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class UserSystem(val name: String, val email: String, var formations: MutableList<Formation>?)


data class ContentEducational(var name: String, val stack: String, val duration: Int, val level: Nivel)

data class Formation(val name: String, var contents: List<ContentEducational>) {

    val subscribes = mutableListOf<UserSystem>()

    fun enroll(vararg users: UserSystem) {
        for(user in users){
            subscribes.add(user);
            if(user.formations == null){
                user.formations = mutableListOf(this);
            } else {
                user.formations?.add(this);
            }
        }
    }
}

fun main() {
    val user1 = UserSystem("Saulo", "sl@teste", null);
    val user2 = UserSystem("Artur", "artur@teste", null);
    val user3 = UserSystem("Gabriele", "gabi@teste", null);
    val user4 = UserSystem("Couto", "couto@teste", null);
    val user5 = UserSystem("Beatriz", "bia@teste", null);


    val contentEducational1 = ContentEducational("Lógica de Programação c/ Java", "JAVA", 45, Nivel.BASICO);
    val contentEducational2 = ContentEducational("APIs JAVA", "JAVA", 75, Nivel.INTERMEDIARIO);
    val contentEducational3 = ContentEducational("Java c/ Spring Boot", "JAVA", 90, Nivel.AVANÇADO);

    val formation = Formation("Back-end", listOf(contentEducational1,contentEducational2,contentEducational3));
    formation.enroll(user1,user2,user3,user4,user5);

    val contentEducational4 = ContentEducational("React", "Framework React.js", 45, Nivel.INTERMEDIARIO);

    val formation2 = Formation("Front-end", listOf(contentEducational4));
    formation2.enroll(user1);

    for(user in formation.subscribes){
        println(user);
    }

}