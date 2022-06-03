package calculator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

private const val EMPTY_MESSAGE = "빈 문자열을 입력하셨습니다."
private const val NUMBER_MESSAGE = "올바른 숫자를 입력해주세요."
private const val OPERATOR_MESSAGE = " 에 해당하는 연산자가 없습니다."

private val calculator = Calculator()

class CalculatorTest : FreeSpec({
    "빈 문자열을 입력하면 예외를 반환한다." {
        val testCases = listOf("", " ")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(EMPTY_MESSAGE) { calculator.calculate(it) }
        }
    }

    "숫자가 있어야 할 자리에 숫자가 아닌 값을 입력하면 예외를 반환한다." {
        val testCases = listOf("ba + da", "+ +")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(NUMBER_MESSAGE) { calculator.calculate(it) }
        }
    }

    "연산자가 있어야 할 자리에 연산자가 아닌 값을 입력하면 예외를 반환한다." {
        val testCases = listOf("$", "bada")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(it + OPERATOR_MESSAGE) { calculator.calculate("1 $it 2") }
        }
    }

    "사칙연산을 수행하고 그 결과를 반환한다." {
        val result = calculator.calculate("2 + 3 * 4 / 2")
        result shouldBe 10
    }
})
