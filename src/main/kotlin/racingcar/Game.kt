package racingcar

class Game {
    private val cars : Cars
    private val turn : Int

    init {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        cars = Cars(readln())
        println("시도할 횟수는 몇 회인가요?")
        turn = inputTurn(readln())
        println()
    }

    private fun inputTurn(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수를 숫자로 입력해주세요.")
        }
    }

    fun play() {
        println("실행 결과")
        for (i in 0 until turn) {
            cars.move()
            cars.print()
            println()
        }

        val winners = cars.findWinners().map { it.name }.toList().joinToString(", ")
        println("$winners 가 최종 우승했습니다.")
    }
}
