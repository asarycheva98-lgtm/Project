import java.time.LocalTime
import java.time.format.DateTimeParseException
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*time()
    wheather()*/
    calculate()
}

fun time() {
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
fun calculate() {
    println("Напиши цифры свои красивые")
    val input = readLine()!!.replace(" ", "")
    val operator = input.find { it == '+' || it == '-' || it == '*' || it == '/' }
    if (operator == null) {
        println("Фигню написал")
        return
    }
    val parts = input.split(operator)
    if (parts.size != 2) {
        println("Ты дурачок? Выражение должно быть a+b")
        return
    }
    val aNullable: Double? = parts[0].toDoubleOrNull()
    val bNullable: Double? = parts[1].toDoubleOrNull()
    if (aNullable == null || bNullable == null) {
        println("Опять фигню пишешь")
    }
    val a: Double = aNullable!!
    val b: Double = bNullable!!
    val result = when (operator) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> {
            if (b == 0.0) {
                println("Ну ема, кто на ноль делит...")
                return
            }
            a / b
        }

        else -> {
            println("Фигню написал")
            return
        }
    }
    println("Результат $result")
}
