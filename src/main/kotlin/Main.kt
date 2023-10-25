fun agoToText(secondsAgo: Int): String {
    when {
        secondsAgo in 1..60 -> return "был(а) только что"
        secondsAgo in 61..3600 -> {
            val minutes = secondsAgo / 60
            return "$minutes ${getMinutesText(minutes)} назад"
        }

        secondsAgo in 3601..86400 -> {
            val hours = secondsAgo / 3600
            return "$hours ${getHoursText(hours)} назад"
        }

        secondsAgo in 86401..172800 -> return "вчера"
        secondsAgo in 172801..259200 -> return "позавчера"
        else -> return "давно"
    }
}

fun getMinutesText(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes != 11 -> "минуту"
        minutes % 10 in 2..4 && minutes !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun getHoursText(hours: Int): String {
    return when {
        hours % 10 == 1 && hours != 11 -> "час"
        hours % 10 in 2..4 && hours !in 12..14 -> "часа"
        else -> "часов"
    }
}

fun main() {
    val secondsAgo = 3600
    val text = agoToText(secondsAgo)
    println(text)
}
