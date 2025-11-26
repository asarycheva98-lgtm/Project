import java.time.LocalTime
import java.time.format.DateTimeParseException
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val timeInput = Scanner(System.`in`).nextLine()
    try {
        val time = LocalTime.parse(timeInput)
        when {
            time in LocalTime.parse("09:00")..LocalTime.parse("09:59") -> println("Проснуться")
            time == LocalTime.parse("10:00") -> println("Поехать на работу")
            time > LocalTime.parse("10:00") -> println("Пора спать")
        }
    } catch (e: DateTimeParseException) {
        println("Фигню написал")
    }

    wheather()
}

fun wheather() {
    val temperature = Scanner(System.`in`).nextInt()
    when {
        temperature >= 0 && temperature <= 7 -> println("Холодно")
        temperature >= 7 && temperature <= 14 -> println("Ну вроде норм")
        temperature >= 14 && temperature <= 22 -> println("Тепло")
        temperature >= 22 -> println("Жара")
    }
}

