package racingcar

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({
    "자동차는 이름을 가질 수 있다" {
        val car = Car("bada")
        car.name shouldBe "bada"
    }

    "자동차의 이름은 5글자를 초과할 수 없다" {
        shouldThrowWithMessage<IllegalArgumentException>("자동차의 이름은 5글자 미만이어야 합니다.") { Car("5글자가 넘는 이름") }
    }
})
