--

# Aturan Umum 

* **Arsitektur:** Single-Activity + 4 Fragment + Navigation Component (SafeArgs).
* **Auth:** Login ke `POST https://reqres.in/api/login`, simpan **token** di SharedPreferences (SP), kirim `Authorization: Bearer <token>` untuk request lainnya.
* **Rotasi (configuration change):**

  * **Wajib** menjaga **posisi list/grid**, **query/filter**, dan **konten yang sedang dibuka**.
  * Gunakan **ViewModel + SavedStateHandle** untuk state ringan, **Room/SP** untuk state yang perlu persist.
* **UI State:** Loading / Empty / Error pakai teks biasa (tanpa ikon).


---

# Team 1 — **VideoPlayerHub** 

**Tujuan:**
User login, pilih konten dari API, lalu **memutar video** (URL demo statis).

**API**

* Auth: `POST https://reqres.in/api/login`
* Konten: `GET https://jsonplaceholder.typicode.com/posts`

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Halaman (Fragment)

### 1) Login Page

* Form email & password → panggil `/api/login`.
* Simpan token di **SP**.
* Loading text/ProgressBar saat login.
* Tampilkan error sederhana bila gagal.

**AC:** Tanpa token tidak bisa lanjut ke halaman lain.

---

### 2) Content List Page

* Ambil `/posts`, tampilkan list (title + excerpt body).
* **Search lokal by title** (EditText + filter list).
* UI state: Loading/Empty/Error (teks biasa).
* Tap item → ke **Content Detail Page**.

**AC Rotasi:**

* **Posisi list** & **query** **tetap** setelah rotasi / kembali dari detail (gunakan ViewModel + SavedStateHandle).

---

### 3) Content Detail (Video Player) Page

* Tampilkan **judul & body** post.
* **Video player** memutar `https://samplelib.com/lib/preview/mp4/sample-5s.mp4`.
* Kontrol dasar: play/pause/seek, indikator buffering, error ramah.

**AC Rotasi:**

* **Posisi playback** (current position) **dipertahankan** saat rotasi (simpan di ViewModel/SavedStateHandle dan `seekTo` saat restore).
* Tidak crash saat orientasi berubah.

---

### 4) Profile Page

* Tampilkan **nama user** (boleh dari email sebelum `@`) + gambar statis dari drawable.
* Tombol **Logout**: hapus token SP → kembali ke Login.

**AC:** Setelah logout, halaman lain terblokir (dicek di guard/login flow).

---



Buat tabel Room **`watch_list`** untuk fitur “**Tonton Nanti**” (Watch Later):

* Field minimal: `postId (PK)`, `title`, `excerpt`, `savedAt`.
* Tambahkan tombol teks **“Simpan untuk ditonton”** di **Content Detail Page**:

  * Klik → **insert** ke Room (jika sudah ada, abaikan/beri pesan).
* Tambahkan sub-halaman/section di **Profile Page** untuk menampilkan daftar **Watch Later**:

  * **List dari Room**, bisa **hapus** item (delete).
  * **Persist** setelah app ditutup/rotasi.

**AC Room:**

* Insert/Delete berfungsi, data muncul ulang setelah restart.
* Navigasi ke detail dari item Watch Later tetap menjaga back position.

---

# Team 2 — **PicsumGallery** 

**Tujuan:**
User login, lihat **grid foto** dari API Picsum, lalu buka **foto full-screen**.

**API**

* Auth: `POST https://reqres.in/api/login`
* Foto: `GET https://picsum.photos/v2/list?page={n}&limit={m}`

  * Thumb: `https://picsum.photos/id/{id}/200/200`
  * Full: dari `download_url`

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Halaman (Fragment)

### 1) Login Page

* Form email & password → `/api/login`.
* Simpan token di SP.
* Loading saat login + error sederhana bila gagal.

**AC:** Token valid tersimpan untuk lanjut.

---

### 2) Photo Grid Page

* Ambil `/v2/list?page=1&limit=30`, tampilkan **grid min. 3 kolom**.
* **Pull-to-Refresh** (reload page 1).
* **Load More** untuk page berikutnya (append).
* **Search lokal by author** (opsional sesuai template awal).
* UI state: Loading/Empty/Error.

**AC Rotasi:**

* **Posisi grid**, **page terakhir**, dan **query author** tetap setelah rotasi / kembali dari detail (ViewModel + SavedStateHandle/SP untuk page).

---

### 3) Photo Detail Page

* Tampilkan **foto besar**, **author**, **ukuran (W×H)**.
* Gesture sederhana: zoom/pan atau tap toggle UI.
* Jika gagal load → teks “Gambar tidak tersedia”.

**AC Rotasi:**

* Kembali (Back) **balik ke posisi grid sebelumnya**, tidak loncat ke atas.

---

### 4) Favorites Page

* Menampilkan daftar **favorit** (dari Room).
* Bisa **hapus** favorit (tombol teks).
* Empty state: “Belum ada favorit”.

---


Tabel Room **`favorite_photos`**:

* Field minimal: `id (PK)`, `author`, `url` (download_url), `thumbUrl` (opsional).
* Di **Photo Detail Page**, tombol teks **“Tambah ke Favorit”**:

  * Insert ke Room; jika sudah ada, abaikan/beri pesan.
* **Favorites Page** menampilkan data dari Room (Flow/LiveData).

**AC Room:**

* Data favorit **persist** setelah restart dan rotasi.
* Delete menghapus dari daftar secara real-time.

---

# Team 3 — **PokeImages** 

**Tujuan:**
User login, lihat daftar **sprite Pokémon**, buka detail untuk melihat **artwork**.

**API**

* Auth: `POST https://reqres.in/api/login`
* Pokémon:

  * List: `GET https://pokeapi.co/api/v2/pokemon?limit=20&offset={n}`
  * Detail: `GET https://pokeapi.co/api/v2/pokemon/{idOrName}`

    * Ambil `sprites.front_default`
    * Ambil `other.official-artwork.front_default`
  * Filter opsional:

    * `GET https://pokeapi.co/api/v2/type`
    * `GET https://pokeapi.co/api/v2/type/{name}`

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Halaman (Fragment)

### 1) Login Page

* Form email & password → `/api/login`.
* Simpan token di SP.
* Loading + error sederhana saat login.

**AC:** Tanpa token, user tidak bisa masuk.

---

### 2) Pokemon List Page

* Ambil daftar Pokémon (paging 20).
* Tampilkan **nama + thumbnail sprite**.
* **Search lokal** by name (opsional sesuai template awal).
* (Opsional) Filter by type menggunakan API `/type`.
* UI state: Loading/Empty/Error.

**AC Rotasi:**

* **Posisi list**, **query**, dan **filter type** tetap setelah rotasi / kembali dari detail (ViewModel + SavedStateHandle; SP untuk filter type jika ingin persist jangka panjang).

---

### 3) Pokemon Detail Page

* Ambil detail `/pokemon/{idOrName}`.
* Tampilkan **sprite** & **official artwork** (fallback ke sprite jika null).
* Info singkat: height, weight, type(s).
* Tombol **“Lihat Artwork Penuh”** → viewer fullscreen.

**AC Rotasi:**

* Back kembali ke posisi list sebelumnya, bukan ke awal.

---

### 4) About Page

* Deskripsi singkat aplikasi.
* Logo/gambar statis dari drawable.
* Tombol **“Cek Koneksi”** → `GET /pokemon?limit=1`, tampilkan **Sukses/Gagal**.

---


Tabel Room **`captured_pokemon`** (anggap fitur “**Tangkap**”/koleksi):

* Field minimal: `idOrName (PK)`, `displayName`, `spriteUrl`, `artworkUrl` (opsional), `caughtAt`.
* Di **Pokemon Detail Page**, tombol teks **“Tambah ke Koleksi”**:

  * Insert ke Room; jika sudah ada, abaikan/beri pesan.
* Tambahkan sub-bagian di **About Page** atau halaman kecil tambahan dalam nav (boleh **“My Collection” Section** di About) untuk **melihat koleksi** dan **hapus**.

**AC Room:**

* Koleksi **persist** setelah restart & rotasi.
* Hapus menghilangkan item dari daftar segera.

---


