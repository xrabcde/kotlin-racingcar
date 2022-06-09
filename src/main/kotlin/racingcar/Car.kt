package racingcar

class Car(val name: String) {
    init {
        require(name.trim().length <= 5) { "자동차의 이름은 5글자 미만이어야 합니다." }
    }
}
