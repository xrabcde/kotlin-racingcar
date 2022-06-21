package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Turn
import racingcar.view.View

class Game {
    private val view : View  = View()

    fun play() {
        val cars = Cars(view.inputNames().map { Car(it) })
        val turn = Turn(view.inputTurn())

        view.printResult()
        repeat(turn.value) {
            cars.move()
            view.printScores(cars)
        }

        view.printWinners(cars.findWinners())
    }
}
