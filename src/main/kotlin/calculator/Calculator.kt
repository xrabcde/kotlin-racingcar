package calculator

import java.util.Objects

class Calculator {
    fun calculate(input: String): Int {
        validateInput(input)
        val splits = input.split(" ").withIndex()
        var tmpValue = 0
        var tmpOperator = Operator.PLUS

        for (split in splits) {
            if (split.index % 2 == 0) {
                tmpValue = tmpOperator.operate(tmpValue, split.value.toInt())
            } else {
                tmpOperator = Operator.findBySymbol(split.value)
            }
        }

        return tmpValue
    }

    private fun validateInput(input: String) {
        if (Objects.isNull(input) || input == "") {
            throw IllegalArgumentException("빈 문자열을 입력하셨습니다.")
        }
    }
}