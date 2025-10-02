### Test on Making Network Calls with HTTP using Retrofit

#### **Optional Questions:**

1. What is Retrofit used for in Android?

   - a) Data storage
   - b) HTTP calls
   - c) UI updates
   - d) Bluetooth communication
   - e) None of the above

2. Which HTTP method is used to send data to a server?

   - a) GET
   - b) POST
   - c) DELETE
   - d) PATCH
   - e) None of the above

3. What is the return type of Retrofit’s API calls?

   - a) JSON
   - b) Call object
   - c) Response object
   - d) String
   - e) None of the above

4. How do you define a base URL in Retrofit?

   - a) `setBaseURL()`
   - b) `withURL()`
   - c) `baseURL()`
   - d) `@BaseURL`
   - e) None of the above

5. Which library is often used with Retrofit for parsing JSON responses?
   - a) Moshi
   - b) SQLite
   - c) OkHttp
   - d) Volley
   - e) None of the above

---

#### **True/False Questions:**

1. Retrofit supports both synchronous and asynchronous API requests.
2. Retrofit cannot handle different HTTP methods like GET, POST, PUT, and DELETE.
3. Retrofit can convert JSON responses into Java/Kotlin objects automatically.
4. Retrofit automatically retries failed network requests.
5. The `@GET` annotation in Retrofit is used for sending data to a server.

---

#### **Short Answer Questions:**

1. What is the purpose of using `GsonConverterFactory` in Retrofit?
2. How do you make an asynchronous network call with Retrofit?
3. What is the difference between synchronous and asynchronous API calls in Retrofit?
4. How do you pass query parameters to a Retrofit API method?
5. Explain how error handling works in Retrofit when a network request fails.

---

#### **Code Fix Questions:**

1. **Incorrect code:**

   ```kotlin
   @GET("users")
   fun getUsers(): Call<List<User>> {
       return retrofit.execute()
   }
   ```

   **Fix the code to correctly make the network request.**

2. **Incorrect code:**

   ```kotlin
   @POST("login")
   fun loginUser(@Body credentials: Map<String, String>): Call<LoginResponse>
   val response = loginUser("username", "password")
   ```

   **Fix the code to properly pass the parameters to the POST request.**

3. **Incorrect code:**
   ```kotlin
   @GET("user/{id}")
   fun getUserById(@Path("id") userId: Int): Call<User>
   getUserById(123).execute()
   ```
   **Fix the code to correctly fetch the user with the given ID asynchronously.**

---

#### MULTIMEDIA

#### **Optional Questions:**

1. Which class is used to play audio files in Android?

   - a) `AudioPlayer`
   - b) `MediaRecorder`
   - c) `MediaPlayer`
   - d) `AudioRecorder`
   - e) `VideoView`

2. What is the purpose of `VideoView` in Android?

   - a) To display and play audio files
   - b) To capture videos from the camera
   - c) To play video content
   - d) To stream live video
   - e) None of the above

3. How do you capture images using the camera in Android?

   - a) Using `Intent.ACTION_IMAGE_CAPTURE`
   - b) Using `Intent.ACTION_VIDEO_CAPTURE`
   - c) Using `MediaRecorder`
   - d) Using `ImageView`
   - e) None of the above

4. Which class is used for recording audio in Android?

   - a) `MediaPlayer`
   - b) `MediaRecorder`
   - c) `AudioRecorder`
   - d) `AudioCapture`
   - e) `SoundPlayer`

5. What is the role of `setVideoURI()` in `VideoView`?
   - a) To start recording video
   - b) To set the path of the video to be played
   - c) To play audio content
   - d) To control audio playback
   - e) None of the above

---

#### **True/False Questions:**

1. `MediaPlayer` is used for both playing and recording audio.
2. The `VideoView` class requires a `MediaController` to play videos.
3. You need runtime permissions to access the device's microphone or camera.
4. The `MediaRecorder` class can be used to capture both audio and video.
5. `ImageView` is used to capture images from the camera in Android.

---

#### **Short Answer Questions:**

1. What is the purpose of `MediaPlayer` in Android?
2. How do you display and play a video in an Android app using `VideoView`?
3. Explain the process of capturing images using the camera in Android.
4. What permissions are required to record audio in an Android app?
5. How can you play an audio file stored in the device’s raw resource directory?

---

#### **Code Fix Questions:**

1. **Incorrect code:**

   ```kotlin
   val mediaPlayer = MediaPlayer()
   mediaPlayer.setAudioSource("audio.mp3")
   mediaPlayer.start()
   ```

   **Fix the code to correctly load and play an audio file using `MediaPlayer`.**

2. **Incorrect code:**

   ```kotlin
   val videoView: VideoView = findViewById(R.id.videoView)
   videoView.setVideoPath("video.mp4")
   videoView.play()
   ```

   **Fix the code to correctly set and start video playback in a `VideoView`.**

3. **Incorrect code:**
   ```kotlin
   val intent = Intent(MediaRecorder.ACTION_IMAGE_CAPTURE)
   startActivityForResult(intent, 1)
   ```
   **Fix the code to correctly capture an image using the camera intent.**

---
