//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//  Soal 1: Nilai Ujian
    val nilai = 90

    if(nilai >= 90){
        println("Nilai A")
    } else if(nilai>=75){
        println("Nilai B")
    } else if(nilai >=60){
        println("Nilai C")
    } else{
        println("Tidak lulus")
    }

    println()

//  Soal 2: Genap atau Ganjil
    val input = 4
    var hasil = if (input % 2 == 0) "Genap" else "Ganjil"
    println("hasil input nya $hasil")

//  Soal 3: Hari dalam Minggu
    val day = 3
    when(day){
        1 -> println("Senin")
        2 -> println("Selasa")
        3 -> println("Rabu")
        4 -> println("Kamis")
        5 -> println("Jumat")
        6 -> println("Sabtu")
        7 -> println("Minggu")
        else -> println("Hari tidak valid")
    }

//  Soal 4: Penilaian Huruf
    val grade = 'A'
    when(grade){
        'A', 'B' -> println("Lulus dengan baik")
        'C' -> println("Lulus pas-pasan")
        'D', 'E' -> println("Tidak lulus")
        else -> println("Grade tidak diketahui")
    }

//  Soal 5: Musim Berdasarkan Bulan
    val month = 12
    val season = when (month){
        12, 1, 6 -> "musim hujan"
        3, 4, 5 -> "musim semi"
        9, 10, 11 -> "musim panas"
        else -> "Nilai tidak valid"
    }
    println("Bulan $month adalah $season")
}
