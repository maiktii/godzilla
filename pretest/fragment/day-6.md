#  Android Fragment

## A. Pilihan Ganda (5 Soal)

**1. Fragment biasanya digunakan untuk:**
```
**a) Menggantikan seluruh Activity**
b) Menampilkan bagian UI dalam sebuah Activity
c) Menghapus Activity dari memori
d) Menjalankan background service
```

**2. Lifecycle method pertama kali dipanggil saat Fragment dibuat adalah:**
```
a) `onResume()`
**b) `onCreateView()`**
c) `onAttach()`
d) `onStart()`
```

**3. Apa fungsi `FragmentTransaction.replace()`?**
```
a) Menambahkan fragment baru di atas fragment lama
b) Menghapus semua fragment yang ada
**c) Mengganti fragment lama dengan fragment baru**
d) Membuat fragment berjalan di background
```

**4. Untuk menambahkan fragment ke Activity melalui XML, digunakan:**
```
a) `<include>`
**b) `<fragment>`**
c) `<LinearLayout>`
d) `<FrameLayout>`
```

**5. Menggunakan `addToBackStack()` pada FragmentTransaction berarti:**
```
a) Fragment tidak bisa kembali
**b) Fragment disimpan agar bisa diakses dengan tombol back**
c) Fragment langsung dihentikan
d) Fragment hanya jalan sekali
```

---

## B. Isian Singkat (5 Soal)

**6.** Sebutkan dua keuntungan menggunakan Fragment dibandingkan hanya Activity. **Answer: Modularitas UI dan responsif terhadap berbagai ukuran layar**

**7.** Bagaimana cara menambahkan fragment secara dinamis dalam Activity menggunakan Kotlin? **Answer: menggunakan supportFragmentManager untuk beginTransaction() dan menggunakan add() dan akhirnya di commit()**

**8.** Lifecycle Fragment mirip dengan Activity. Sebutkan minimal 3 perbedaan pentingnya. **Answer: Lifecycle tambahan pada fragment, Fragment tergantung pada activity, dan view lifecycle yang terpisah**

**9.** Apa perbedaan `add()` dan `replace()` pada FragmentTransaction? **Answer: add(): menambahkan fragment ke container tanpa menghapus fragment yang sudah ada, replace(): mengganti dengan fragment yang baru**

**10.** Bagaimana cara mengirim data dari Activity ke Fragment? **Answer: menggunakan bundle untuk mengirim key dan value lalu di kirimkan menggunakan fragment.arguments**

---

## C. Perbaikan Kode (10 Soal)

**11. Perbaiki kode berikut agar fragment bisa ditampilkan dengan benar:**

```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.container, ExampleFragment)
    .commit()
```

- correction
```kotlin
supportFragmentManager.beginTransaction()
    .add(R.id.container, ExampleFragment)
    .addToBackStack(name)
    .commit()
```

---

**12. Ada kesalahan pada penggunaan `onCreateView` berikut. Perbaiki:**

```kotlin
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    return inflater.inflate(R.layout.fragment_example, null)
}
```

- correction:
```kotlin
override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    return inflater.inflate(R.layout.fragment_example, container, false)
}
```

---

**13. Fragment ingin mengirim data ke Activity, tapi ada kesalahan. Perbaiki:**

```kotlin
(activity as MainActivity).showMessage = "Hello"
```

- correction:
```kotlin
(activity as MainActivity).showMessage.("Hello")
```

---

**14. Kode berikut crash karena `FragmentTransaction` belum dijalankan dengan benar. Perbaiki:**

```kotlin
val fragment = ExampleFragment()
supportFragmentManager.beginTransaction()
    .replace(R.id.container, fragment)
```

- correction
```kotlin
val fragment = ExampleFragment()
supportFragmentManager.beginTransaction()
    .replace(R.id.container, fragment)
    .addToBackStack(name)
    .commit()
```

---

**15. Kode berikut salah saat memanggil fragment lewat XML. Perbaiki:**

```xml
<fragment
    android:id="@+id/myFragment"
    android:name="com.example.MyActivity"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

- correction
```xml
<fragment
    android:id="@+id/myFragment"
    android:name="com.example.MyFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

**16. Perbaiki agar fragment bisa menerima argument `username`:**

```kotlin
val fragment = ProfileFragment()
fragment.arguments.putString("username", "khalid")
```

- correcction
```kotlin
val fragment = ProfileFragment()
val bundle = Bundle()
bundle.putString("username", "khalid")
```

---

**17. Perbaiki agar fragment bisa dipanggil dari Activity menggunakan `supportFragmentManager`:**

```kotlin
val manager = supportFragment
manager.beginTransaction().add(R.id.container, MyFragment()).commit()
```

- correction
```kotlin
supportFragmentmanager.beginTransaction()
    .add(R.id.container, MyFragment())
    .addToBackStack(name)
    .commit()
```

---

**18. Ada error pada penggunaan `childFragmentManager`. Perbaiki:**

```kotlin
childFragmentManager.beginTransaction()
    .add(R.id.container, AnotherFragment)
    .commit()
```

- correction
```kotlin
val fragment = AnotherFragment()
childFragmentManager.beginTransaction()
    .add(R.id.container, fragment)
    .commit()
```

---

**19. Perbaiki kode komunikasi antar Fragment melalui Activity:**

```kotlin
val fragment = SecondFragment()
fragment.setTargetFragment(FirstFragment(), 1)
```

- correction 
```kotlin
val firstFragment = parentFragmentManager.findFragmentByTag("FirstFragment") as? FirstFragment
val secondFragment = SecondFragment()
secondFragment.setTargetFragment(firstFragment, 1)
```


---

**20. Perbaiki kode berikut agar fragment bisa dipanggil dengan `newInstance`:**

```kotlin
val fragment = DetailFragment("id123")
supportFragmentManager.beginTransaction()
    .replace(R.id.container, fragment)
    .commit()
```

- correction:
```kotlin
val fragment = DetailFragment()
val bundle = Bundle()
bundle.putString("id", "id123")
fragment.arguments = bundle
supportFragmentManager.beginTransaction()
    .replace(R.id.container, fragment)
    .commit()
```

---

## buat projectkan di folder /pretest dengan nama project fragment

#  3 Fragment (XML) 

## Struktur Target

* 1 Activity: `MainActivity`
* 3 Fragment: `HomeFragment`, `DetailFragment`, `SettingsFragment`
* Navigasi manual pakai `FragmentManager` (tanpa Navigation Component)
* Mock data disediakan (bisa diubah siswa)

---

## 1) Layout Activity (container)

**`app/src/main/res/layout/activity_main.xml`**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- Container untuk fragment -->
    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

---

## 2) Mock Data (boleh kalian ubah)

**`app/src/main/java/.../data/MockBooks.kt`**

```kotlin
package com.example.app.data

data class Book(val title: String, val author: String)

object MockBooks {
    val items: List<Book> = listOf(
        Book("Clean Code", "Robert C. Martin"),
        Book("Kotlin in Action", "Dmitry Jemerov"),
        Book("Android Apprentice", "raywenderlich Team")
    )
}
```

---

## 3) Fragment Layouts (XML)

**A. `fragment_home.xml`**
List sederhana + judul.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" 
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:text="Home"
        android:textSize="20sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <!-- bisa diganti RecyclerView -->
    <ListView
        android:id="@+id/listViewBooks"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

    <Button
        android:id="@+id/btnOpenSettings"
        android:text="Open Settings"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

**B. `fragment_detail.xml`**
Tampilkan informasi buku + tombol back ke Home.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" 
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/tvTitle"
        android:text="Title"
        android:textStyle="bold"
        android:textSize="18sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <TextView
        android:id="@+id/tvAuthor"
        android:text="Author"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btnBackHome"
        android:text="Back to Home"
        android:layout_marginTop="16dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

**C. `fragment_settings.xml`**
Switch dummy + tombol back.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" 
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:text="Settings"
        android:textSize="20sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <Switch
        android:id="@+id/switchOnlyFavorite"
        android:text="Only Favorite (mock)"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/btnBackHome"
        android:text="Back to Home"
        android:layout_marginTop="16dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</LinearLayout>
```

---

## 4) Fragment Classes (Kotlin)

**A. `HomeFragment.kt`**

* Menampilkan list dari `MockBooks`
* Klik item → buka `DetailFragment` dengan argumen index
* Klik tombol → buka `SettingsFragment`

```kotlin
package com.example.app.ui

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.app.R
import com.example.app.data.MockBooks

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView = view.findViewById<ListView>(R.id.listViewBooks)
        val titles = MockBooks.items.map { it.title }
        listView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, titles)

        listView.setOnItemClickListener { _, _, position, _ ->
            (requireActivity() as MainActivity).navigateTo(
                DetailFragment.newInstance(position),
                addToBackStack = true
            )
        }

        view.findViewById<View>(R.id.btnOpenSettings).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(
                SettingsFragment.newInstance(),
                addToBackStack = true
            )
        }
    }
}
```

**B. `DetailFragment.kt`**

* Ambil `index` dari args → tampilkan detail dari `MockBooks`

```kotlin
package com.example.app.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.app.R
import com.example.app.data.MockBooks

class DetailFragment : Fragment() {

    companion object {
        private const val ARG_INDEX = "arg_index"

        fun newInstance(index: Int) = DetailFragment().apply {
            arguments = Bundle().apply { putInt(ARG_INDEX, index) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val idx = arguments?.getInt(ARG_INDEX) ?: -1
        val book = MockBooks.items.getOrNull(idx)

        view.findViewById<TextView>(R.id.tvTitle).text = book?.title ?: "Unknown"
        view.findViewById<TextView>(R.id.tvAuthor).text = "by ${book?.author ?: "-"}"

        view.findViewById<Button>(R.id.btnBackHome).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(HomeFragment.newInstance(), addToBackStack = false)
        }
    }
}
```

**C. `SettingsFragment.kt`**

* Switch hanya mock (tampilkan toast/log)
* Tombol back ke Home

```kotlin
package com.example.app.ui

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.app.R

class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_settings, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Switch>(R.id.switchOnlyFavorite).setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(requireContext(), "Only Favorite: $isChecked (mock)", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btnBackHome).setOnClickListener {
            (requireActivity() as MainActivity).navigateTo(HomeFragment.newInstance(), addToBackStack = false)
        }
    }
}
```

---

## 5) Main Activity (helper navigasi)

**`MainActivity.kt`**

* Muat `HomeFragment` pertama kali
* Sediakan fungsi `navigateTo(fragment, addToBackStack)`

```kotlin
package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.app.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateTo(HomeFragment.newInstance(), addToBackStack = false)
        }
    }

    fun navigateTo(fragment: Fragment, addToBackStack: Boolean = true) {
        val tx = supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)

        if (addToBackStack) {
            tx.addToBackStack(fragment::class.java.simpleName)
        }
        tx.commit()
    }
}
```

---

## 6) Cara Pakai & Modifikasi
* **Ubah mock list** di `MockBooks.items` (ganti judul/author).
* **Tambah field** (misal `isFavorite: Boolean`) dan tampilkan di Detail.
* **Ganti ListView → RecyclerView** 
* **Ubah alur**: dari Settings set flag (sementara bisa pakai `object` global) lalu filter list di Home.

---
