package racingcar.domain

data class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.trim().length in NAME_LENGTH_RANGE) { "자동차 이름은 1글자에서 5글자 사이로 입력해주세요." }
    }

    fun move(condition: Int) {
        if (condition >= MIN_MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private var NAME_LENGTH_RANGE: IntRange = (1..5)
        private var MIN_MOVE_CONDITION: Int = 4
    }
}
