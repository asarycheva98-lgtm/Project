open class Customer(
    val name: String,
    var balance: Double,
) {
    open fun pay(amount: Double): Boolean {
        return if (balance >= amount) {
            balance -= amount
            println("$name оплатил $amount. Остаток $balance")
            true
        } else {
            println("$name нищеброд. Нужно $amount")
            false
        }
    }


    open fun order(food: Food, distance: Int, courier: Courier ): Order? {
        println("$name хочет заказать: ${food.name} цена ${food.price}")
        return if (pay(food.price)) {
            Order(this, courier, food, distance)
        } else null
    }
}

class VipCustomer(name: String, balance: Double) : Customer(name, balance) {
    override fun pay(amount: Double): Boolean {
        val dicountPrice = amount * 0.9
        println("$name (VIP) получает скидку $dicountPrice. Остаток $balance")
        return if (balance >= dicountPrice) {
            balance -= dicountPrice
            println("$name оплатил $dicountPrice. Остаток $balance")
            true
        } else {
            println("$name нищеброд")
            false
        }
    }

    override fun order(food: Food, distance: Int, courier: Courier): Order? {
        println("$name хочет заказать: ${food.name} цена ${food.price}")
        return if (pay(food.price)) {
            Order(this, courier, food, distance)
        } else null
    }
}

interface Deliverable {
    fun calculateDeliveryTime(distance: Int): Int
    fun deliver(order: Order)
}

class Courier(val name: String, val speed: Int) : Deliverable {
    override fun calculateDeliveryTime(distance: Int): Int {
        return speed / distance
    }

    override fun deliver(order: Order) {
        val time = calculateDeliveryTime(order.distance)
        println("Курьер $name доставляет заказ ${order.food.name} покупателю ${order.customer.name}. Время в пути $time минут")
    }
}

abstract class Food(
    val name: String,
    val price: Double
) {
    abstract fun cook()
}

class Pizza(name: String, price: Double) : Food(name, price) {
    override fun cook() {
        println("Пицца '$name' готовится в печи 10 минут")
    }
}

class Burger(name: String, price: Double) : Food(name, price) {
    override fun cook() {
        println("Бургер '$name' жарится на гриле 5 минут")
    }
}
class Sushi(name: String,price: Double) : Food(name, price){
    override fun cook() {
        println("Суши '$name' аккуратно крутятся поваром 7 минут")
    }
}
class Order(
    val customer: Customer,
    val courier: Courier,
    val food: Food,
    val distance: Int
){
    fun process() {
        println("\n=== Обработка заказа для ${customer.name} ===")
        println("Заказ создан.")
        val deliveryTime = courier.calculateDeliveryTime(distance)
        println("Курьер ${courier.name} оценивает время доставки на расстояние $distance км как $deliveryTime минут")
        courier.deliver(this)
        println("Заказ с ${food.name} для ${customer.name} - завершен")
    }
}
fun main () {
    val courier = Courier("Данияр", speed = 25)

    println("===Обычный клиент====")
    val alisher: Customer = Customer(name = "Алишер", balance = 300.00)
    val order1 = alisher.order(Pizza("Пепперони", 1500.00), 8, courier)
    order1?.process()

    println("\n===VIP клиент===")
    val anfisa: VipCustomer = VipCustomer(name = "Анфиса", balance = 2000.00)
    val order2 = anfisa.order(Sushi("Филадельфия", 1800.00), 5,courier)
    order2?.process()
}