package racingcar

fun main() {
    println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val cars = Cars(readln())
    println("시도할 횟수는 몇 회인가요?")
    val turn = readln()

    println("\n실행 결과")
    for (i in 0 until turn.toInt()) {
        cars.move()
        cars.print()
        println()
    }

    val winners = cars.findWinners().map { it.name }.toList().joinToString(", ")
    println("$winners 가 최종 우승했습니다.")
}
