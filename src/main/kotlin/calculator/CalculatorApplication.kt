package calculator

fun main() {
    print("입력 : ")
    val calculator = Calculator(readln())
    println(calculator.calculate().value)
}
