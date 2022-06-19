package racingcar.domain

class Cars(val values: List<Car>) {
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
