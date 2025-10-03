#### **Optional Questions:**

1. What is the purpose of Shared Preferences in Android?

   - a) To store large amounts of data in a relational format.
   - b) **To store small key-value pairs for user preferences or settings.**
   - c) To store large media files like images and videos.
   - d) To interact with external databases.
   - e) None of the above.

2. Which method is used to save data in Shared Preferences?

   - a) **`apply()`**
   - b) `savePreferences()`
   - c) `writePreferences()`
   - d) `store()`
   - e) `commit()`

3. How can you remove a specific key from Shared Preferences?

   - a) `clearKey()`
   - b) **`remove()`**
   - c) `deleteKey()`
   - d) `deletePreference()`
   - e) `removeKey()`

4. Where is data stored when using Shared Preferences?

   - a) External storage
   - b) **Internal storage in XML format**
   - c) SQLite database
   - d) In-memory cache
   - e) Cloud storage

5. What data types can be stored in Shared Preferences?
   - a) `String`, `int`, `boolean`
   - b) `String`, `int`, `ArrayList`
   - c) `String`, `int`, `boolean`, `ArrayList`
   - d) **`String`, `int`, `float`, `boolean`, `Set<String>`**
   - e) `String`, `float`, `JSONArray`

---

#### **True/False Questions:**

1. Shared Preferences can be used to store complex objects like lists or JSON data. **False**
2. Data saved in Shared Preferences is lost when the app is closed. **True**
3. `apply()` saves data asynchronously, while `commit()` saves it synchronously. **True**
4. Shared Preferences can store large amounts of data such as images or videos. **False**
5. You can access Shared Preferences from multiple activities in an Android app. **True**

---

#### **Short Answer Questions:**

1. What is the difference between `apply()` and `commit()` in Shared Preferences? **Answer: apply() saves data asynchronously, while commit() saves it synchronously.**
2. How would you store a user's login status (true/false) using Shared Preferences in Android? **Answer: from the main activity will used the getSharedPreferences(name, mode) then edit the data user login status then apply it**
3. How can you read data from Shared Preferences in Android? **Answer: by parsing the set preferences by editting the original value then parsing it by (key, value) then using the getString/getBoolean to get the parsed value**
4. What are the advantages of using Shared Preferences over other storage options for small amounts of data? **Answer: simplicity, lightweight and private by default**
5. Can you modify Shared Preferences from multiple threads? Explain your answer. **Answer: SharedPreferences is thread-safe for read operations. You can safely call getBoolean(), getString(), etc., from multiple threads without issues. SharedPreferences.Editor is not thread-safe. If multiple threads are modifying preferences at the same time using Editor, you may encounter race conditions or data loss.**

---

#### **Code Fix Questions:**

1. **Incorrect code:**

   ```kotlin
   val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
   val editor = sharedPref.edit()
   editor.putValue("username", "JohnDoe")
   editor.apply()
   ```

   **Fix the code to store the correct data.**

   - correction 
   ```kotlin
   val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
   with(sharedPref.edit()){
      putValue("username", "JohnDoe")
      apply()
   }
   ```

2. **Incorrect code:**

   ```kotlin
   val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
   val username = sharedPref.getValue("username", "defaultName")
   ```

   **Fix the code and explain the correct method to read from Shared Preferences.**

   - correction
    ```kotlin
   val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)
   val username = sharedPref.getString("username", "defaultName")
   ```

3. **Incorrect code:**
   ```kotlin
   val editor = sharedPref.edit()
   editor.clear("key")
   editor.commit()
   ```
   **Fix the code to properly remove a key from Shared Preferences.**

   - correction
   ```kotlin
   val editor = sharedPref.edit()
   editor.remove("key")
   editor.commit()
   ```

---
