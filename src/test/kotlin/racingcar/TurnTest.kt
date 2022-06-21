package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import racingcar.domain.Turn

private const val TURN_ERROR_MESSAGE = "시도할 횟수를 숫자로 입력해주세요."

class TurnTest : FreeSpec({
    "시도할 횟수가 숫자가 아니면 예외를 반환한다" {
        val testCases = listOf("", " ", "bada")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(TURN_ERROR_MESSAGE) { Turn(it) }
        }
    }
})
