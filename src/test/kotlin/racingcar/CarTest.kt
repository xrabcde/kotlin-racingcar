package racingcar

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec({
    "자동차는 이름을 가질 수 있다" {
        val car = Car("bada")
        car.name shouldBe "bada"
    }
})
