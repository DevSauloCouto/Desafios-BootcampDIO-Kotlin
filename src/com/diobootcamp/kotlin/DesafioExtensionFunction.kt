package com.diobootcamp.kotlin

fun main() {


    val title = readLine() ?: "";
    val author = readLine() ?: "";

    val slugTitle = title.generateSlug();
    val slugAuthor = author.generateSlug();

    println("Slug gerado para o livro:")

    println(slugTitle + "_" + slugAuthor)
}

fun String.generateSlug(): String {
    return this.split(Regex("""\s|\W+""")).joinToString(separator = "-") { it.lowercase() };
}