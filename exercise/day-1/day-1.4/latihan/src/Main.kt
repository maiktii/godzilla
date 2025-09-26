//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//  Soal 1 — Hitung Total Nilai
    val arrNum = arrayOf(70, 85, 90, 60, 75)
    var result = 0
    for (num in arrNum){
        result += num
    }

    println("Total Nilai: $result")

//  Soal 2 — Cari Angka Genap
    val arrAngka = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    for(angka in arrAngka){
        if (angka % 2 != 0){
            continue
        }

        println("Angka genap : $angka")
    }

//  Soal 3 — Cari Buah Tertentu
    val arrFruits = arrayOf("Apple", "Banana", "Mango", "Orange", "Grapes")
    for (fruit in arrFruits){
        if (fruit == "Mango"){
            println("Mango ditemukan!")
            break
        }
    }

//  Soal 4 — Hitung Mundur
    var count = 10
    while (count >= 1) {
        println(count)
        count--
    }
    println("Selesai!")

//  Soal 5 — Cetak Nama dengan Index
    val arrSiswa = arrayOf("Andi", "Budi", "Cici", "Dedi")
    for ((index, siswa) in arrSiswa.withIndex()){
        println("${index+1}. $siswa")
    }

}