package calculator

import java.util.Objects

class Calculator {
    fun calculate(input: String): Int {
        validateInput(input)
    }

    private fun validateInput(input: String) {
        if (Objects.isNull(input) || input == "") {
            throw IllegalArgumentException("빈 문자열을 입력하셨습니다.")
        }
    }
}