package com.bbs.learnandtest.enums

enum class ProgressColor(val value: Int) {

    GREEN(1),
    BLUE(2),
    RED(3);

    fun compare(progressColor: ProgressColor): Boolean {
        return this == progressColor
    }
}