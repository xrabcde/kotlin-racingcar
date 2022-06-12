package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.View

class Game {
    private val view : View
    private val cars : Cars
    private val turn : Int

    init {
        view = View()
        cars = Cars(view.inputNames())
        turn = validTurn(view.inputTurn())
    }

    private fun validTurn(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수를 숫자로 입력해주세요.")
        }
    }

    fun play() {
        view.printResult()
        for (i in 0 until turn) {
            cars.move()
            view.printScores(cars)
        }

        view.printWinners(cars.findWinners().map { it.name }.toList())
    }
}
