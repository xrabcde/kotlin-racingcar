package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import racingcar.domain.Car

private const val NAME_LENGTH_MESSAGE = "자동차 이름은 1글자에서 5글자 사이로 입력해주세요."

class CarTest : FreeSpec({
    "자동차는 이름을 가질 수 있다" {
        val car = Car("bada")
        car.name shouldBe "bada"
    }

    "자동차의 이름이 1글자에서 5글자 사이가 아니라면 예외를 반환한다" {
        val testCases = listOf("", " ", "5글자가 넘는 이름")
        testCases.forAll {
            shouldThrowWithMessage<IllegalArgumentException>(NAME_LENGTH_MESSAGE) { Car(it) }
        }
    }

    "무작위 숫자가 4 이상일 때 전진한다" {
        val car = Car("bada")
        car.move(4)
        car.position shouldBe 1
    }

    "무작위 숫자가 4 미만일 때 움직이지 않는다" {
        val car = Car("bada")
        car.move(3)
        car.position shouldBe 0
    }
})
