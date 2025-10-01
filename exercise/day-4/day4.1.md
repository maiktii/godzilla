## 1) “Seminar: Profil Peserta & Buku Tamu”

**Tujuan:** Form pendaftaran dengan profil yang tersimpan, plus buku tamu lokal.

- **SharedPreferences (SP):** simpan `NAME`, `EMAIL`, `REMEMBER_ME` (Boolean).
- **Room (Entity):** `Participant(id:Long, name:String, email:String, checkedIn:Boolean)`.
- **Alur:**
  MainActivity auto-fill dari SP → kirim ke SecondActivity untuk konfirmasi → SecondActivity menambah pesertanya ke Room (jika belum ada) → ThirdActivity menampilkan ringkasan dan total peserta dari Room.
- **Tugas Implementasi:**

  1. Main: `load()` SP saat `onCreate`, `save()` saat Submit.
  2. Second: baca profil (Intent fallback ke SP), **insert** ke Room jika `name+email` belum ada (cek sederhana).
  3. Third: baca **count peserta** dari Room dan tampilkan; tombol Selesai kirim `RETURN_FROM_THIRD`.

- **Goals:**

  - Profil auto-fill setelah app dibuka ulang (SP).
  - Peserta baru tersimpan di Room; Third menampilkan total peserta dari Room.

---

## 2) “Movie Night: Preferensi User & Kode Booking”

**Tujuan:** Simpan preferensi tampilan dan daftar booking lokal.

- **SP:** `DEFAULT_SHOWTIME` (mis. “19:00”), `LAST_MOVIE_TITLE`.
- **Room (Entity):** `Booking(id:Long, movieTitle:String, showTime:String, code:String, createdAt:Long)`.
- **Alur:**
  Main ambil `DEFAULT_SHOWTIME` untuk prefill jam → kirim judul & jam ke Second → Second buat `code` (dummy), **insert** ke Room → Main simpan `LAST_MOVIE_TITLE` di SP → Third menampilkan tiket terakhir (ambil **row terbaru** dari Room).
- **Tugas:**

  1. Main: prefill jam dari SP; saat konfirmasi, `save(DEFAULT_SHOWTIME=showTime)` & `save(LAST_MOVIE_TITLE=movieTitle)`.
  2. Second: buat `MV-xxxxx`, insert ke Room, `setResult(BOOKING_CODE)`.
  3. Third: query `ORDER BY createdAt DESC LIMIT 1`, tampilkan tiket.

- **Goals:**

  - Jam tayang prefill dari SP.
  - Booking tersimpan di Room dan tiket terakhir tampil di Third.

---

## 3) “Kantin: Preferensi Pedas & Riwayat Pesanan”

**Tujuan:** Simpan preferensi rasa & daftar pesanan lokal.

- **SP:** `PREF_SPICY` (Boolean), `LAST_NOTE`.
- **Room (Entity):** `Order(id:Long, menu:String, note:String, spicy:Boolean, total:Int, createdAt:Long)`.
- **Alur:**
  Main prefill switch pedas dari SP → kirim ke Second → Second hitung `total` (dummy) dan **insert** Order ke Room → Third menampilkan **riwayat terakhir 5 pesanan** dari Room.
- **Tugas:**

  1. Main: saat user ubah switch pedas, simpan ke SP; saat submit, simpan `LAST_NOTE`.
  2. Second: hitung total, insert, return `ORDER_TOTAL`.
  3. Third: query `LIMIT 5`, tampilkan list (RecyclerView).

- **Goals:**

  - Switch pedas ingat preferensi (SP).
  - Riwayat pesanan tampil dari Room (min. 1 entry setelah order).

---

## 4) “Arah Kampus: Gedung Favorit & Log Navigasi”

**Tujuan:** Simpan gedung favorit user & catat log buka peta.

- **SP:** `FAVORITE_BUILDING`, `LAST_LAT`, `LAST_LNG`.
- **Room (Entity):**

  - `Building(id:Long, name:String, lat:Double, lng:Double, favorite:Boolean)`
  - `NavLog(id:Long, buildingName:String, opened:Boolean, timestamp:Long)`

- **Alur:**
  Main prefill gedung & koordinat dari SP → kirim ke Second → Second coba buka Maps (implicit), **insert** NavLog ke Room (opened/canceled) → Third menampilkan **daftar gedung favorit** (query Building.favorite=1) dan jumlah log navigasi.
- **Tugas:**

  1. Main: tombol “Jadikan Favorit” → simpan ke SP & **upsert** ke `Building(favorite=true)` di Room.
  2. Second: buka Maps (try/catch), insert `NavLog`.
  3. Third: tampilkan list favorit + total log (count).

- **Goals:**

  - Favorit tersimpan di SP dan di Room.
  - Log navigasi bertambah setiap kali mencoba buka peta.

---

## 5) “Photo Notes: Filter Tampilan & Database Catatan”

**Tujuan:** Simpan preferensi filter dan catatan lokal.

- **SP:** `FILTER_TEXT` (untuk pencarian), `GRID_MODE` (Boolean).
- **Room (Entity):** `Note(id:Long, title:String, photoUri:String, createdAt:Long)`.
- **Alur:**
  Main simpan preferensi filter & grid di SP → ke Second untuk “pilih foto dummy” (URI), **insert** Note ke Room → Third menampilkan **list Note** dari Room yang **difilter** berdasarkan `FILTER_TEXT` SP, mode grid/list mengikuti `GRID_MODE` SP.
- **Tugas:**

  1. Main: UI filter & toggle grid, simpan ke SP saat berubah.
  2. Second: hasil pilih foto (dummy) → insert ke Room.
  3. Third: baca `FILTER_TEXT`, `GRID_MODE` dari SP lalu query Room (LIKE) & atur layout manager (Grid/Linear).

- **Goals:**

  - Preferensi tampilan/teks bertahan (SP).
  - List catatan muncul sesuai filter & mode dari SP (data dari Room).

---

## 6) “Task Manager: Preferensi Sortir & Daftar Tugas”

**Tujuan:** Simpan preferensi urutan dan tugas lokal.

- **SP:** `SORT_BY` (`"created"` / `"priority"`), `SHOW_DONE` (Boolean).
- **Room (Entity):** `Task(id:Long, title:String, priority:Int, done:Boolean, createdAt:Long)`.
- **Alur:**
  Main menyimpan preferensi sortir & “tampilkan selesai” di SP → ke Second untuk ubah status task (`IN_PROGRESS`/`DONE`) → perubahan **update** di Room → Third menampilkan daftar task **dengan query** sesuai preferensi SP (order by & where done).
- **Tugas:**

  1. Main: kontrol sortir & toggle SHOW_DONE, simpan ke SP.
  2. Second: pilih task (by id extras), update `done` di Room, return status.
  3. Third: baca preferensi SP → query Room dinamis (ORDER BY, WHERE) → tampilkan ke RecyclerView.

- **Goals:**

  - Perubahan preferensi mengubah urutan/penyaringan.
  - Update status task di Room tercermin pada tampilan Third.

---

```
team 1 (1,2)
team 2 (3,4)
team 3 (5,6)
```
