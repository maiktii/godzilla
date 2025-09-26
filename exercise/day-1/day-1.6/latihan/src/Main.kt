import kotlin.math.max

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val data = calculateStats(listOf(70, 85, 90, 60))

    println("---SOAL 1---")
    println("Stats : $data")
    println()
    println("---SOAL 2---")
    segitiga(6)
    println()
    println("---SOAL 3---")
    println(isPalindrome("level"))
    println(isPalindrome("kotlin"))
    println()

    val dataKedua = listOf(10, 30, 20, 50, 40)
    val result = findSecondLargest(dataKedua)
    println("---SOAL 4---")
    println("Angka tertinggi kedua adalah: $result")
    println()
    println("---SOAL 5---")
    println(countWords("Belajar Kotlin itu mudah"))
    println()
    println("---SOAL 6---")
    soal6()
    println()

}


fun calculateStats(numbers: List<Int>): Map<String, Double> {
    var total = 0
    for (num in numbers) {
        total += num
    }

    val average = total.toDouble() / numbers.size
    val max = numbers.maxOrNull() ?: 0
    val min = numbers.minOrNull() ?: 0


    return mapOf("total" to total.toDouble(), "average" to average, "max" to max.toDouble(), "min" to min.toDouble())
}

fun segitiga(n: Int){
    for (i in 1..n) {
        for (j in 1..i) {
            print("*")
        }
        println()
    }
}

fun isPalindrome(text: String): Boolean{
    val reversed = text.reversed()
    return text == reversed
}

fun findSecondLargest(numbers: List<Int>): Int? {
    if (numbers.size < 2) return null

    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

    for (num in numbers) {
        if (num > largest) {
            secondLargest = largest
            largest = num
        } else if (num > secondLargest && num != largest) {
            secondLargest = num
        }
    }

    return if (secondLargest == Int.MIN_VALUE) null else secondLargest
}

fun countWords(sentence: String): Int {
    var count = 0
    var inWord = false

    for (char in sentence) {
        if (char != ' ') {
            if (!inWord) {
                count++
                inWord = true
            }
        } else {
            inWord = false
        }
    }

    return count
}

fun soal6() {
    val A = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6)
    )

    val B = arrayOf(
        arrayOf(7, 8, 9),
        arrayOf(1, 2, 3)
    )

    val rows = A.size
    val cols = A[0].size

    val result = Array(rows) { Array(cols) { 0 } }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            result[i][j] = A[i][j] + B[i][j]
        }
    }

    println("Hasil penjumlahan matriks:")
    for (row in result) {
        println(row.joinToString(" "))
    }
}

