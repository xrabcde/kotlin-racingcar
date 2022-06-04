package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

private const val NO_SUCH_SYMBOL_MESSAGE = " 에 해당하는 연산자가 없습니다."

class OperatorTest : FreeSpec({
    "symbol에 해당하는 연산자를 반환한다." {
        val operators = listOf(
            row("+", Operator.PLUS),
            row("-", Operator.MINUS),
            row("*", Operator.MULTIPLY),
            row("/", Operator.DIVIDE)
        )
        operators.forEach { (symbol, result) ->
            Operator.findBySymbol(symbol) shouldBe result
        }
    }

    "symbol에 해당하는 연산자가 없다면 예외를 반환한다." {
        val testCases = listOf("1", "bada")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(it + NO_SUCH_SYMBOL_MESSAGE) { Operator.findBySymbol(it) }
        }
    }

    "주어진 연산자에 맞는 사칙연산을 수행한다." {
        val testCases = listOf(
            row(Operator.PLUS, 6),
            row(Operator.MINUS, 2),
            row(Operator.MULTIPLY, 8),
            row(Operator.DIVIDE, 2)
        )
        testCases.forEach { (operator, result) ->
            operator.operate(4, 2) shouldBe result
        }
    }
})
