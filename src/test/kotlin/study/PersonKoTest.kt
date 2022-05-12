package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("조아라", 20, "바다"),
            Person("조아라", 20, nickname = "바다"),
            Person(name = "조아라", age = 20, nickname = "바다")
        )
        people.forAll {
            it.name shouldBe "조아라"
            it.age shouldBe 20
            it.nickname shouldBe "바다"
        }
    }

    "널 타입" {
        val person = Person("조아라", 20, null)
        person.name shouldBe "조아라"
        person.age shouldBe 20
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("조아라", 20)
        person.name shouldBe "조아라"
        person.age shouldBe 20
        person.nickname shouldBe "조아라"
    }

    "데이터 클래스" {
        val person1 = Person("조아라", 20)
        val person2 = Person("조아라", 20)
        person1 shouldBe person2
    }
})