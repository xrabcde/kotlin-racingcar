package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Turn
import racingcar.view.View

class Game {
    private val view : View
    private val cars : Cars
    private val turn : Turn

    init {
        view = View()
        cars = Cars(view.inputNames())
        turn = Turn(view.inputTurn())
    }

    fun play() {
        view.printResult()
        repeat(turn.value) {
            cars.move()
            view.printScores(cars)
        }
        view.printWinners(cars.findWinners().map { it.name }.toList())
    }
}
