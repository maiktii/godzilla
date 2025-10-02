## Bagian A — Pilihan Ganda (10 Soal)

```
1. SharedPreferences cocok digunakan untuk…
   a) Menyimpan foto profil pengguna
   b) Menyimpan token login dan setting ringan
   c) Menyimpan database transaksi
   d) Menyimpan file audio

2. Default mode paling aman untuk membuat SharedPreferences adalah:
   a) MODE_MULTI_PROCESS
   b) MODE_APPEND
   c) MODE_PRIVATE
   d) MODE_WORLD_READABLE

3. Perbedaan `apply()` dan `commit()` di SharedPreferences.Editor:
   a) `apply()` sinkron, `commit()` async
   b) `apply()` async, `commit()` sinkron
   c) Keduanya async
   d) Keduanya sinkron

4. SharedPreferences disimpan secara fisik di…
   a) RAM
   b) Internal storage sandbox aplikasi
   c) External storage
   d) Firebase Realtime Database

5. Komponen wajib Room:
   a) @Model, @Repository, @Database
   b) @Entity, @Dao, @Database
   c) @Entity, @ViewModel, @Database
   d) @Table, @SQLite, @Repository

6. Primary key auto-generate di Room ditulis:
   a) `@PrimaryKey val id: Int`
   b) `@PrimaryKey(autoGenerate = true) val id: Int = 0`
   c) `@Id(auto = true) val id: Int`
   d) `@Primary(auto = true) val id: Int`

7. Jika kita mengubah struktur tabel Room tanpa migrasi:
   a) Database auto-update aman
   b) Crash dengan `IllegalStateException`
   c) Hanya warning di log
   d) Room pindah otomatis ke SharedPreferences

8. Untuk operasi database berat di Room agar tidak ANR, sebaiknya:
   a) Jalankan langsung di Main Thread
   b) Gunakan `allowMainThreadQueries()`
   c) Gunakan coroutine Dispatchers.IO atau RxJava
   d) Pakai Thread.sleep

9. `@Insert(onConflict = REPLACE)` di Room artinya:
   a) Menolak insert jika sudah ada row
   b) Menghapus semua data lama
   c) Menimpa data lama dengan primary key sama
   d) Tidak ada efek

10. Untuk mendapatkan data real-time dari Room:
    a) Return `LiveData` atau `Flow` di DAO
    b) Return `Int` di DAO
    c) Return `String` di DAO
    d) Tidak bisa real-time


```

---

## Bagian B — Isian Singkat (3 Soal)

11. Tulis kode satu baris untuk mendapatkan SharedPreferences bernama `"prefs"` di `Context`.

12. Sebutkan 2 perbedaan `apply()` dan `commit()` di SharedPreferences.

13. Bagaimana membuat singleton instance RoomDatabase bernama `AppDb` (builder standar, tanpa DI)?

---

## Bagian C — Perbaikan Kode (7 Soal)

14. Perbaiki kode agar menyimpan string `username` dengan benar:

```kotlin
val prefs = getSharedPreferences("user", MODE_PRIVATE)
prefs.edit()
putString("username", name)
apply()
```

15. Apa output berikut jika key `"counter"` belum pernah dibuat?

```kotlin
val p = getSharedPreferences("app", MODE_PRIVATE)
val counter = p.getInt("counter", 5)
p.edit().putInt("counter", counter + 1).commit()
val after = p.getInt("counter", 0)
println(after)
```

16. Tambahkan kode listener agar mendeteksi perubahan key `"theme"` di SharedPreferences dan unregister di `onDestroy()`.

17. Perbaiki entity Room berikut:

```kotlin
@Entity(tableName = "notes")
data class Note(
  @PrimaryKey(autoGenerate = true)
  val id: Int?,
  val title: String,
  @ColumnInfo(defaultValue = "''")
  val content: String
)
```

18. DAO berikut error, perbaiki:

```kotlin
@Dao
interface NoteDao {
  @Insert
  suspend fun insertAll(notes: List<Note>): Int
}
```

19. Lengkapi kode untuk membuat database dan mengambil semua `Note` di background:

```kotlin
val db = AppDb.getInstance(context)
// ???
println(all.size)
```

20. Perbaiki query DAO berikut agar mengambil semua user terurut ASC:

```kotlin
@Query("GET * FROM users ORDER name ASC")
fun getAll(): List<User>
```

---
