package racingcar

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.Cars

class CarsTest : FreeSpec({
    "가장 멀리 간 자동차가 우승한다" {
        val 바다차 = Car("바다")
        val 포비차 = Car("포비")
        val 제이슨차 = Car("제이슨")
        val cars = Cars(listOf(바다차, 포비차, 제이슨차))

        바다차.move(5)
        포비차.move(1)
        제이슨차.move(1)

        cars.findWinners().size shouldBe 1
        cars.findWinners().shouldContainExactly("바다")
    }

    "우승자는 한 명 이상일 수 있다" {
        val 바다차 = Car("바다")
        val 포비차 = Car("포비")
        val 제이슨차 = Car("제이슨")
        val cars = Cars(listOf(바다차, 포비차, 제이슨차))

        바다차.move(5)
        포비차.move(1)
        제이슨차.move(5)

        cars.findWinners().size shouldBe 2
        cars.findWinners().shouldContainExactly("바다", "제이슨")
    }
})
