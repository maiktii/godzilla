# Tim 1— PokeAPI (Catalog, Filter, Detail)

## Base URL

- Auth (login): `https://reqres.in/api/`
- Data: `https://pokeapi.co/api/v2/`

## Halaman & Panggilan API

1. **LoginPage**

   - `POST /login` (ReqRes) body: `{ "email": "eve.holt@reqres.in", "password": "cityslicka" }`
   - Simpan `token` ke SharedPreferences/in-memory.

2. **PokemonListPage**

   - **Load awal (pagination 20 per halaman)**
     `GET /pokemon?limit=20&offset={page*20}`
   - **Search (client-side)**

     - Tidak ada endpoint search fuzzy, lakukan filter di memori berdasarkan nama dari hasil yang sudah dimuat, atau:
     - Untuk exact match, boleh langsung: `GET /pokemon/{name}` dan jika 404 → “not found”.

   - **Filter by Type**

     - Ambil daftar type: `GET /type`
     - Saat type dipilih: `GET /type/{typeName}` → ambil `pokemon[].pokemon.name`.
       (Batasi ke 40 item pertama, lalu untuk setiap nama panggil detail ringan atau tampilkan nama saja terlebih dulu.)

   - **Infinite Scroll** (opsional): tambah `offset` saat scroll mendekati bawah.

3. **PokemonDetailPage**

   - `GET /pokemon/{idOrName}`
   - Tampilkan: sprite (front_default), height, weight, types, abilities, base stats (bar chart sederhana).
   - **Prefetch kecil**: ketika user di list, prefetch 3 item teratas.

## Acceptance Criteria (AC)

- Login sukses → token tersimpan → redirect ke PokemonListPage.
- List menampilkan minimal 20 item per page (nama, sprite).
- Filter type bekerja dan bisa digabung dengan search (search di hasil filter).
- Detail menampilkan seluruh field yang diminta.
- Loading, error, dan empty state jelas.
- Back dari detail kembali ke posisi list sebelumnya.
- Semua request setelah login menyertakan header `Authorization`.

## Edge Cases

- Network error (timeouts) → tombol Retry.
- `GET /pokemon/{name}` 404 → tampilkan “Tidak ditemukan”.
- Ketika `type` mengembalikan sangat banyak Pokemon, batasi 40 item dengan indikator “show more” (opsional).

---

# Tim 2 — JSONPlaceholder (Posts ↔ Comments, Filter by User)

## Base URL

- Auth (login): `https://reqres.in/api/`
- Data: `https://jsonplaceholder.typicode.com/`

## Halaman & Panggilan API

1. **LoginPage**

   - `POST /login` (ReqRes) body: `{ "email": "eve.holt@reqres.in", "password": "cityslicka" }`

2. **PostListPage**

   - **Load awal**: `GET /posts`
   - **Filter by User**:

     - Ambil users untuk dropdown: `GET /users`
     - Saat user dipilih: `GET /posts?userId={id}`

   - **Refresh**: pull-to-refresh memanggil ulang endpoint aktif (semua atau filtered).

3. **PostDetailPage**

   - `GET /posts/{id}`
   - Tab **Comments**:

     - `GET /posts/{id}/comments` (atau `GET /comments?postId={id}`)

   - Tampilkan: title, body, daftar comments (name, email, body).

4. **CreateEditPostPage** _(mock CRUD, opsional tambahan)_

   - Create: `POST /posts` body: `{ "title": "...", "body": "...", "userId": <id> }`
   - Edit: `PATCH /posts/{id}` body: `{ "title": "..." }` (atau `PUT` untuk replace)
   - Setelah sukses, **optimistic update** ke list.

## Acceptance Criteria (AC)

- Login flow dan token tersimpan.
- PostList menampilkan minimal 20 item, ada loading & error state.
- Dropdown Users muncul dari `/users`, filter bekerja (status kosong bila tak ada hasil).
- Detail menampilkan post dan komentar.
- (Opsional) Create/Edit mock tampilkan payload response & update list lokal.
- Semua request menyertakan header `Authorization`.

## Edge Cases

- Gagal load `/users` → tetap tampilkan list posts, dropdown disabled.
- Post tidak ditemukan (id salah) → tampilkan “Not found” + tombol Back.

---

# Tim 3 — JSONPlaceholder (Todos Dashboard)

## Base URL

- Auth (login): `https://reqres.in/api/`
- Data: `https://jsonplaceholder.typicode.com/`

## Halaman & Panggilan API

1. **LoginPage**

   - `POST /login` (ReqRes) body: `{ "email": "eve.holt@reqres.in", "password": "cityslicka" }`

2. **TodosListPage**

   - **Load awal**: `GET /todos`
     (Jika terlalu besar, load paginated client-side: ambil 100 lalu bagi per 20 di UI.)
   - **Filter**:

     - Completed only: `GET /todos?completed=true`
     - Active only: `GET /todos?completed=false`

   - **Search (client-side)**:

     - Filter berdasarkan substring pada `title`.

3. **TodoDetailPage** _(opsional)_

   - Tampilkan detail satu item todo (id, title, userId, completed).
   - Tombol toggle “completed” **lokal** (mock): hanya ubah di UI (tidak panggil API PUT).

4. **UserTodosPage** _(opsional variasi)_

   - Dropdown users: `GET /users`
   - `GET /todos?userId={id}` untuk melihat todos per user.

## Acceptance Criteria (AC)

- Login flow dan token tersimpan.
- TodosList menampilkan list dengan checkbox status completed.
- Filter by completed/active jalan; search client-side berfungsi.
- (Opsional) User filter bekerja (dropdown dari `/users`).
- Toggle completed **tidak** mengubah server (mock), beri label “local change only”.
- Semua request menyertakan header `Authorization`.

## Edge Cases

- `GET /todos` gagal → tampilkan Retry.
- Kombinasi filter + search menghasilkan 0 → tampilkan empty state jelas.

---
