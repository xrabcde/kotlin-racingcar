package racingcar

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Cars

class CarsTest : FreeSpec({
    "쉼표로 구분한 자동차의 이름을 입력하면 자동차들이 생성된다" {
        val cars = Cars("bada, pobi, jason")
        cars.values.size shouldBe 3
        cars.values[0].name shouldBe "bada"
        cars.values[1].name shouldBe "pobi"
        cars.values[2].name shouldBe "jason"
    }

    "가장 멀리 간 자동차가 우승한다" {
        val cars = Cars("bada, pobi, jason")
        cars.values[0].move(5)
        cars.findWinners().size shouldBe 1
        cars.findWinners()[0] shouldBe "bada"
    }

    "우승자는 한 명 이상일 수 있다" {
        val cars = Cars("bada, pobi, jason")
        cars.values[0].move(5)
        cars.values[1].move(5)
        cars.findWinners().size shouldBe 2
    }
})
