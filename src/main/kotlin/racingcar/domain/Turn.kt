package racingcar.domain

class Turn(input: String) {
    var value: Int

    init {
        value = validTurn(input)
    }

    private fun validTurn(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("시도할 횟수를 숫자로 입력해주세요.")
        }
    }
}
