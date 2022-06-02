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
                tmpValue = numberTurn(tmpValue, tmpOperator, split.value)
            } else {
                tmpOperator = operatorTurn(split.value)
            }
        }

        return tmpValue
    }

    private fun validateInput(input: String) {
        if (Objects.isNull(input) || input == "") {
            throw IllegalArgumentException("빈 문자열을 입력하셨습니다.")
        }
    }

    private fun numberTurn(tmpValue: Int, operator: Operator, value: String): Int {
        try {
            val newValue = value.toInt()
            return operator.operate(tmpValue, newValue)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("올바른 숫자를 입력해주세요.")
        }
    }

    private fun operatorTurn(value: String): Operator {
        return Operator.findBySymbol(value)
    }
}