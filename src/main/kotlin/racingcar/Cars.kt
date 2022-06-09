package racingcar

class Cars(names: String) {
    var cars: List<Car> = emptyList()
        private set

    init {
        val splitNames = names.split(", ")
        for (name in splitNames) {
            cars += Car(name)
        }
    }
}
