//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val area = calculateRectangleArea(8, 5)
    println("Luas Area : $area")
    val checkGaGe  = checkEvenOdd(7)
    println("Input berupa angka $checkGaGe")

    sayHi()
    sayHi("Mike")

    val sqrtNum = square(9)
    println("Angka kuadrat adalah $sqrtNum")

    val sumListAnswer = sumList(listOf(1,2,3,4,5))
    println("Total value array : $sumListAnswer")

}

fun calculateRectangleArea(length: Int, width: Int): Int{
    return length * width
}

fun checkEvenOdd(number: Int): String{
    if (number % 2 == 0){
        return "Genap"
    } else{
        return "Ganjil"
    }
}

fun sayHi(name: String = "Guest"){
    println("Hi, $name")
}

fun square(n: Int) = n * n

fun sumList(numbers: List<Int>): Int{
    var result = 0;
    for (num in numbers){
        result += num
    }

    return result
}