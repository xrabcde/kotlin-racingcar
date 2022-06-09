package racingcar

class Cars(names: String) {
    var cars: List<Car> = emptyList()
        private set

    init {
        val splitNames = names.split(", ")
        for (name in splitNames) {
            cars += Car(name)
        }
    }

    fun move() {
        for (car in cars) {
            val random = (0..9).random()
            car.move(random)
        }
    }

    fun print() {
        for (car in cars) {
            println(car.printPosition())
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
