package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("조아라", 20, "바다"),
            Person("조아라", 20, nickname = "바다"),
            Person(name = "조아라", age = 20, nickname = "바다")
        )
        assertThat(people[0].name).isEqualTo("조아라")
        assertThat(people[1].name).isEqualTo("조아라")
        assertThat(people[2].name).isEqualTo("조아라")
    }

    @Test
    fun `널 타입`() {
        val person = Person("조아라", 20, null)
        assertThat(person.name).isEqualTo("조아라")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("조아라", 20)
        assertThat(person.name).isEqualTo("조아라")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("조아라")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("조아라", 20)
        val person2 = Person("조아라", 20)
        assertThat(person1).isEqualTo(person2)
    }
}