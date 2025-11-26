
package org.sopt.sopt_collaboration_panelnow.core.common.util

import java.text.NumberFormat
import java.util.Locale

fun Long.toPointFormat(): String {
    val formatter = NumberFormat.getNumberInstance(Locale.KOREA)
    return "${formatter.format(this)}P"
}

fun String.toPointFormat(): String {
    return try {
        val number = this.toLongOrNull() ?: return "${this}P"
        number.toPointFormat()
    } catch (e: Exception) {
        "${this}P"
    }
}

fun String.maskPhoneNumber(): String {
    val digitsOnly = this.filter { it.isDigit() }

    return when (digitsOnly.length) {
        11 -> {
            "${digitsOnly.substring(0, 5)}******"
        }
        10 -> {
            "${digitsOnly.substring(0, 5)}*****"
        }
        else -> this
    }
}