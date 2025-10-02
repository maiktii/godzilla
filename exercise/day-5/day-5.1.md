
---

# team 1 — **VideoPlayerHub** (fokus: PUTAR VIDEO)

**Tujuan:** user login, pilih konten dari API, lalu **memutar video** (URL demo statis).

**API yang dipakai**

* **Auth (wajib):** `POST https://reqres.in/api/login`
* **Konten list:** `GET https://jsonplaceholder.typicode.com/posts` (judul & deskripsi)

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Page

1. **Login Page**
   **Isi & perilaku:**

   * Input email & password → panggil `/api/login` (ReqRes), simpan token di SharedPreferences.
   * Loading + error message jika gagal.
     **AC:** Tanpa token, tak bisa lanjut.

2. **Content List Page**
   **Isi & perilaku:**

   * Ambil `/posts`, tampilkan list (title + excerpt).
   * Search client-side di list (berdasarkan title).
   * Tap item → ke Detail.
     **AC:** Loading, error, empty state jelas; minimal 20 item tampil saat sukses.

3. **Content Detail (Video Player) Page**
   **Isi & perilaku:**

   * Tampilkan judul & body post (dari `/posts/{id}`—boleh ambil dari list yang sudah ada).
   * **Video player** memutar URL demo (misal `https://samplelib.com/lib/preview/mp4/sample-5s.mp4`).
   * Kontrol dasar: play/pause/seek, indikator buffering.
     **AC:** Video dapat diputar stabil; error media memberi pesan yang ramah; orientasi layar tak menyebabkan crash.

4. **Profile Page**
   **Isi & perilaku:**

   * Tampilkan data profil sederhana (boleh hardcode nama dari email login) + avatar **foto statis** dari drawable/asset.
   * Tombol Logout (hapus token SP → kembali ke Login).
     **AC:** Logout membersihkan token; setelah logout, akses halaman lain diarahkan ke Login.

---

# team 2 — **VideoPlayerHub** (fokus: PUTAR VIDEO)
 2 — **PicsumGallery** (fokus: LIHAT FOTO)

**Tujuan:** user login, lihat **grid foto** dari API Picsum, buka **foto full-screen**.

**API yang dipakai**

* **Auth (wajib):** `POST https://reqres.in/api/login`
* **Foto:** `GET https://picsum.photos/v2/list?page={n}&limit={m}`
  (thumbnail bisa pakai `https://picsum.photos/id/{id}/200/200`, full pakai `download_url`)

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Page

1. **Login Page**
   **Isi & perilaku:** sama seperti Soal 1.
   **AC:** token tersimpan di SP, wajib untuk lanjut.

2. **Photo Grid Page**
   **Isi & perilaku:**

   * Ambil `/v2/list?page=1&limit=30`, tampilkan **grid** (min. 3 kolom).
   * Pull-to-refresh dan tombol “Load More” (page berikutnya).
   * Search client-side by **author**.
     **AC:** Loading/error/empty state; grid responsif; pagination bekerja.

3. **Photo Detail Page**
   **Isi & perilaku:**

   * Tampilkan **foto ukuran besar** (full-screen viewer), author, ukuran (W×H).
   * Gesture dasar: zoom/pan (boleh sederhana: fit center + tap to toggle UI).
     **AC:** Gambar muncul tajam, fallback placeholder saat gagal; tombol Back kembali ke posisi list sebelumnya.

4. **Favorites Page**
   **Isi & perilaku:**

   * User bisa **menandai foto** sebagai favorit dari Detail.
   * Halaman ini menampilkan **foto-foto favorit** (data disimpan di Room; hanya simpan id/author/url yang diperlukan).
     **AC:** Favorit persist setelah restart; hapus favorit menghilangkan dari list.

**Catatan SP:**
Simpan pengaturan **grid columns** (2/3) dan **last_opened_page** untuk restore state.

---

# team 3 — **PokeImages** (fokus: LIHAT FOTO sprite & artwork)

**Tujuan:** user login, lihat **gambar Pokémon** (sprite/artwork) dari PokeAPI, buka detail bergambar.

**API yang dipakai**

* **Auth (wajib):** `POST https://reqres.in/api/login`
* **Pokémon:**

  * `GET https://pokeapi.co/api/v2/pokemon?limit=20&offset={n}`
  * `GET https://pokeapi.co/api/v2/pokemon/{idOrName}` (ambil `sprites.front_default` dan `other.official-artwork.front_default`)
  * (Filter optional) `GET https://pokeapi.co/api/v2/type` dan `.../type/{name}`

> Semua request setelah login kirim header: `Authorization: Bearer <token>`

## 4 Page

1. **Login Page**
   **Isi & perilaku:** sama seperti sebelumnya.
   **AC:** token valid disimpan di SP.

2. **Pokemon List Page**
   **Isi & perilaku:**

   * Ambil list Pokémon (limit 20/paging).
   * Tampilkan **nama + thumbnail** (sprite).
   * Search client-side by name; optional filter by type (pakai `/type`).
     **AC:** Loading/error/empty; scroll/pagination mulus.

3. **Pokemon Detail (Image-focused) Page**
   **Isi & perilaku:**

   * Ambil detail `GET /pokemon/{idOrName}`.
   * Tampilkan **sprite** dan **official artwork** (jika ada) + info singkat (height/weight/type).
   * Tombol “Lihat Artwork Penuh” menampilkan gambar besar (viewer sederhana).
     **AC:** Gambar tampil; jika artwork tidak ada, fallback ke sprite; back kembali ke posisi list.

4. **About Page**
   **Isi & perilaku:**

   * Deskripsi singkat aplikasi (read-only).
   * **Gambar statis** (logo/ilustrasi) ditampilkan.
   * Tombol “Cek Koneksi” untuk mencoba satu request ringan (e.g., `GET /pokemon?limit=1`) dan menunjukkan status (sukses/gagal).
     **AC:** Status koneksi tampil; error ditangani ramah.

---


