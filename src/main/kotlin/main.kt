const val MINUTE =  60
const val HOUR =  60 * 60
const val DAY = 60 * 60 * 24

fun main() {
    agoToText(55)
    agoToText(360)
    agoToText(43_200)
    agoToText(86_900)
    agoToText(173_800)
    agoToText(270_200)
}

fun agoToText(seconds: Int): String {
    when {
        isSecond(seconds) -> println("Был(а) только что")
        isMinutes(seconds) -> println("Был(а) ${agoMinuteTime(seconds)} назад")
        isHour(seconds) -> println("Был(а) в сети ${agoHourTime(seconds)} назад")
        isToday(seconds) -> println("Был(а) в сети сегодня")
        isYesterday(seconds) -> println("Был(а) в сети вчера")
        isLongAgo(seconds) -> println("Был(а) в сети давно")
    }
    return ""
}

fun agoMinuteTime(seconds: Int): String {
    val minutes = seconds / MINUTE
    if (minutes in 11..14) return "$minutes минут"
    when (minutes % 10) {
        1 -> return "$minutes минуту"
        2,3,4 -> return "$minutes минуты"
        5,6,7,8,9,0 -> return "$minutes минут"
    }
    return ""
}

fun agoHourTime(seconds: Int): String {
    val hour = seconds / HOUR
    if (hour in 11..14) return "$hour часов"
    when (hour % 10) {
        1 -> return "$hour час"
        2,3,4 -> return "$hour часа"
        5,6,7,8,9,0 -> return "$hour часов"
    }
    return ""
}


fun isSecond(seconds: Int): Boolean {
    return seconds <= MINUTE
}

fun isMinutes(seconds: Int): Boolean {
    return seconds in (MINUTE + 1)..HOUR
}

fun isHour(seconds: Int): Boolean {
    return seconds in (HOUR + 1)..DAY
}

fun isToday(seconds: Int): Boolean {
    return seconds in (DAY + 1)..DAY * 2
}

fun isYesterday(seconds: Int): Boolean {
    return seconds in (DAY * 2 + 1)..DAY * 3
}

fun isLongAgo(seconds: Int): Boolean {
    return seconds > DAY * 3
}