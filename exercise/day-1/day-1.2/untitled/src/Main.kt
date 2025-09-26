//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//  Bagian 1 — Aritmatika
    val length = 7
    val width = 4

    println("Luas persegi panjang : ${length * width}")

    val radius = 10
    val pi = 3.14159
    println("Keliling lingkaran : ${2 * pi * radius}")

    println("Sisa pembagian 200/7 : ${200%7}")

//  Bagian 2 — Perbandingan
    val x = 100
    val y = 200

    println("x lebih kecil dari y? ${x < y}")

    val temp = 36.5

    println("apakah temp sama dengan 37.0? ${temp == 37.0}")

    val a = 50
    val b = 50

    println("apakah a = b? ${a == b}")

//  Bagian 3 — Logika
    val isSunny = true
    val isRaining = false

    println("apakah hari ini terang? ${isSunny && !isRaining}")

    val hasMoney = true
    val isStoreOpen = false

    println("apakah bisa belanja? ${hasMoney && isStoreOpen}")

    val isWeekend = true
    val isHoliday = false

    println("apakah hari ini libur? ${isWeekend || isHoliday}")

//  Bagian 4 — Assignment
    var num = 8
    num += 5
    num *=2
    num -=3
    num /= 5

    println("Hasil akhir num : $num")

    var price = 1000
    price -= price * 20/100
    println("Harga setelah diskon : $price")

//  Bagian 5 — Increment / Decrement
    var counter = 10
    counter++
    counter++
    counter--
    counter--
    counter--
    println("Hasil akhir counter : $counter")

    var points = 0
    points++
    points++
    points++
    points++
    points++
    points--

    println("Hasil akhir point : $points")

}