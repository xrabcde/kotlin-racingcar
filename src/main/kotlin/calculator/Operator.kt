package calculator

enum class Operator(val symbol: String, val operate: (Int, Int) -> Int) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.symbol == symbol }
                ?: throw IllegalArgumentException("$symbol 에 해당하는 연산자가 없습니다.")
        }
    }
}