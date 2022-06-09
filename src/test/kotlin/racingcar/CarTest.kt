package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

private const val NAME_LENGTH_MESSAGE = "자동차 이름은 1글자에서 5글자 사이로 입력해주세요."

class CarTest : FreeSpec({
    "자동차는 이름을 가질 수 있다" {
        val car = Car("bada")
        car.name shouldBe "bada"
    }

    "자동차의 이름은 5글자를 초과할 수 없다" {
        val testCases = listOf("", " ", "5글자가 넘는 이름")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(NAME_LENGTH_MESSAGE) { Car(it) }
        }
    }
})
