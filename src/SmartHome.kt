/*fun main() {

    val korzina = listOf<Frukt>(
        Apple(
            color = "red",
            chervyachok = true
        ),
        Apple(
            color = "green",
            chervyachok = false
        ),
        Grusha(
            color = "green"
        ),
    )

    korzina.get(2).status()
}

abstract class Frukt(
    val color: String
) {
    abstract fun fuck()

    fun status(){

    }
}

class Apple(
    color: String,
    val chervyachok: Boolean
) : Frukt(color) {
    override fun fuck() {
        println("appl")
    }
}

class Grusha(
    color: String
) : Frukt(color) {
    override fun fuck() {
        println("grusha")
    }
}

class Ananas(
    val color: String
)*/


abstract class SmartDevice(
    val name: String
) {
    abstract fun turnOn()
    abstract fun turnOff()

    fun status() {
        println("Устройство: $name $isOn")
    }

}

class SmartLamp(name: String) : SmartDevice(name) {
    override fun turnOn() {
        if (isOn) {
            println("Устройство: \"$name\" уже включена")
            return
        }
        isOn = true
        println("Устройство: \"$name\" включилась")
    }

    override fun turnOff() {
        if (!isOn) {
            println("Устройство: \"$name\" уже выключена")
            return
        }
        isOn = false
        println("Устройство: \"$name\" выключена")
    }
}

class SmartTV(name: String) : SmartDevice(name) {
    override fun turnOn() {
        if (isOn) {
            println("Устройство \"$name\" уже включено")
            return

        }
        isOn = true
        println("Устройство \"$name\" включен")

    }

    override fun turnOff() {
        if (!isOn) {
            println("Устройство \"$name\" уже выключено")
            return
        }
        isOn = false
        println("Устройство \"$name\" выключено")

    }
}

class SmartAirConditioner(name: String, val temperature: Int) : SmartDevice(name) {
    override fun turnOn() {
        if (isOn) {
            println("Устройство \"$name\" уже включен")
            return
        }
        isOn = true
        println("Устройство \"$name\" включен")

    }

    override fun turnOff() {
        if (!isOn) {
            println("Устройство \"$name\" уже выключено")
            return
        }
        isOn = false
        println("Устройство \"$name\" выключено")

    }
}

fun controlDevice(device: SmartDevice) {
    while (true) {
        println()
        println("1 - Включить")
        println("2 - Выключить")
        println("3 - Статус")
        println("0 - Назад")
    }
    when (readLine()) {
        "1" -> device.turnOn()
        "2" -> device.turnOff()
        "3" -> device.status()
        "0" -> return
        else -> println("Что-то пошло не так")
    }


}

fun main() {
    val device = listOf<SmartDevice>(
        SmartLamp(
            "Ночник Геннадий"),
        SmartTV(
            "Телевизор Антон"),
        SmartAirConditioner(
            "Кондиционер Евгений", temperature = 25)



    )
}












































