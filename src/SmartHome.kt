fun main() {
    val device = listOf<SmartDevice>(
        SmartLamp(
            "Ночник Геннадий"),
        SmartTV(
            "Телевизор Антон"),
        SmartAirConditioner(
            "Кондиционер Евгений", temperature = 25)
    )
    device.forEach { controlDevice(it) }
}
abstract class SmartDevice(
    val name: String,
    var isOn: Boolean
) {
    abstract fun turnOn()
    abstract fun turnOff()

    fun status() {
        println("Устройство: \"$name\" | Включено: \"$isOn\"")
    }

}

class SmartLamp(
    name: String,
    isOn: Boolean = false
) : SmartDevice(name, isOn) {
    override fun turnOn() {
        if (isOn) {
            println("Устройство: \"$name\" уже включен")
            return
        }
        isOn = true
        println("Устройство: \"$name\" включился")
    }

    override fun turnOff() {
        if (!isOn) {
            println("Устройство: \"$name\" уже выключен")
            return
        }
        isOn = false
        println("Устройство: \"$name\" выключен")
    }
}

class SmartTV(
    name: String,
    isOn: Boolean = false
) : SmartDevice(name, isOn) {
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

class SmartAirConditioner(
    name: String,
    isOn: Boolean = false,
    val temperature: Int
) : SmartDevice(name, isOn) {
    override fun turnOn() {
        if (isOn) {
            println("Устройство \"$name\" уже включен")
            return
        }
        isOn = true
        println("Устройство \"$name\" включен, температура: $temperature")

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
    device.turnOn()
    device.status()
    device.turnOff()
    device.status()

}














































