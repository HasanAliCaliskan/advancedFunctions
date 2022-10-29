package com.hasanali.kotlinadvancedfunctions

import kotlinx.coroutines.test.withTestContext

fun main() {




    val myList = listOf<Int>(1,5,43,7,34,2,66,18,0,49)


    // "all" metodu tüm listede sorgu yapar (and mantığı). Boolean döndürür.
    val allCheck = myList.all { it > 5 }
    println(allCheck) // false

    // "any" metodu tüm listede sorgu yapar (or mantığı). Boolean döndürür.
    val anyCheck = myList.any { it > 5 }
    println(anyCheck) // true

    // "count" verilen koşula uygun elemanın sayısını döndürür.
    val totalCount = myList.count { it > 5 }
    println(totalCount) // 6

    // "find" verilen koşula uyan ilk elemanı döndürür.
    val findNum = myList.find { it > 5 }
    println(findNum) // 43

    // "findLast" verilen koşula uyan son elemanı döndürür.
    val findLastNum = myList.findLast { it > 5 }
    println(findLastNum) // 49


    val myPredicate = {num: Int -> num > 5}

    val allCheckWithPredicate = myList.all(myPredicate)
    println(allCheckWithPredicate) // false













    /*
    val myList = listOf<Int>(1,5,43,7,34,2,66,18,0,49)

    val filteredList = myList.filter { it < 10 }
    for (number in filteredList) {
        println(number)
    }

     */

    /*
    val musicians = listOf<Musicians>(
        Musicians("James", 60, "Guitar"),
        Musicians("Lars", 55, "Drum"),
        Musicians("Kirk", 50, "Guitar"),
    )

    val instrumentList = musicians.filter { it.age < 60 }.map { it.instrument }

     */
}

data class Musicians(val name: String, val age: Int, val instrument: String)