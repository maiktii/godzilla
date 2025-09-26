import kotlin.collections.mutableListOf

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//  Bagian 1 — Dasar (Data Type & Print)
    var studentName: String = "Mike"
    var age: Int = 21
    var temperature: Float = 36.7f
    var isGraduated: Boolean = false
    var grade: Char = 'A'

    println(studentName)
    println(age)
    println(temperature)
    println(isGraduated)
    println(grade)

//  Bagian 2 — Numeric Types
    var population: Long = 273_000_000
    var smallNumber: Short = 3200
    var tinyValue: Byte = 127

    println("Population: $population, Small Number:  $smallNumber, Tiny Value : $tinyValue")

//  Bagian 3 — Nullable
    var nickname: String? = null
    println("nickname sebelum : $nickname")
    nickname = "Mike"
    println("nickname sesudah : $nickname")

//  Bagian 4 — Array & Collection
    val numbers = arrayOf(1,2,3,4,5)
    print("Semua elemen numbers: ${numbers.toList()}")

    val listOfFruits: List<String> = listOf("Apple", "Banana", "Mango")
    print("List Buah : $listOfFruits")

    var mutableListOfScores = mutableListOf(80, 85, 90)
    mutableListOfScores.add(95)
    println("Mutable List Score : $mutableListOfScores")

    val setOfNumbers = setOf(1, 2, 2, 3, 3, 4)
    println(setOfNumbers)

    val mapOfStudent: Map<String, Int> = mapOf("Math" to 90, "Science" to 85)
    println(mapOfStudent)

//  Bagian 5 — Mix & Match
    var city = "Jakarta"
    var year = 2025
    var pi = 3.14159

    println("City : $city, Year : $year PI : $pi")

    var isLoggedIn = false
    println("sebelum logged in : $isLoggedIn")
    isLoggedIn = true
    println("sesudah logged in : $isLoggedIn")

    val charList = arrayOf("M", "I", "K", "E")
    println(charList.toList())

//  Bagian 6 — Tantangan
    var studentInfo = mutableMapOf<String, Any>("name" to "Mike", "age" to 21, "score" to 66.6, "isGraduated" to false)

    println("Student Info $studentInfo")

    val grades: Array<Char> = arrayOf('A', 'B', 'C', 'D', 'E')
    println("Array pertama : ${grades[0]}")
    println("Array terakhir : ${grades[grades.size - 1]}")


    val hobbies = mutableListOf("Membaca", "Bermain musik", "Bersepeda")
    hobbies.remove("Bermain musik")
    println("Hobi saya sekarang: $hobbies") 
}

