package racingcar.view

import racingcar.domain.Cars

class View {
    fun inputNames(): String {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln()
    }

    fun inputTurn(): String {
        println("시도할 횟수는 몇 회인가요?")
        return readln()
    }

    fun printResult() {
        println()
        println("실행 결과")
    }

    fun printScores(cars: Cars) {
        cars.values.forEach {
            println(it.getPosition())
        }
        println()
    }

    fun printWinners(winnerList: List<String>) {
        val winners = winnerList.joinToString(", ")
        println("$winners 가 최종 우승했습니다.")
    }
}
