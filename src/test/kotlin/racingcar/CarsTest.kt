package racingcar

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CarsTest : FreeSpec({
    "쉼표로 구분한 자동차의 이름을 입력하면 자동차들이 생성된다" {
        val cars = Cars("bada, pobi, jason")
        cars.cars.size shouldBe 3
        cars.cars[0].name shouldBe "bada"
        cars.cars[1].name shouldBe "pobi"
        cars.cars[2].name shouldBe "jason"
    }
})
