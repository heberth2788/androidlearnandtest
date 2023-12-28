package com.bbs.learnandtest.collections

class ListOperations {

    val listAux = listOf<Int>(1, 2, 3, 4, 5, 6)

    fun waysToIterate() {
        /**
         * Using List.forEach
         * */
        listAux.forEach { value ->
            println("$value")
        }

        /**
         * Using List.forEachIndexed
         * */
        listAux.forEachIndexed { index, value ->
            println("$index has the value $value")
        }

        /**
         * Using List.iterator
         * */
        val iterator = listAux.iterator()
        while(iterator.hasNext()) {
            val value = iterator.next()
            println("$value")
        }

        /**
         * Using for-in-until
         * */
        for(index in 0 until listAux.size) {
            println("${ listAux[index] }")
        }

        /**
         * Using for-in
         * */
        for(value in listAux) {
            println("$value")
        }
    }
}