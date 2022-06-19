package racingcar.domain

class Cars(names: String) {
    var values: List<Car> = emptyList()
        private set

    init {
        val splitNames = names.split(", ")
        for (name in splitNames) {
            values += Car(name)
        }
    }

    fun move() {
        values.forEach {
            it.move((0..9).random())
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = values.maxOf { it.position }
        return values.filter { it.position == maxPosition }.map { it.name }.toList()
    }
}
