# Rick and Morty Character Viewer
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/f9a0c6c8-e71f-4e2d-9efe-efc496fbff86" width="250" alt="App Icon">

## Overview
The **Rick and Morty Character Viewer** is a very plain information viewer app that does a very simple task of fetching data from an API and viewing it on the UI. It makes use of some of the latest and most popular libraries that are commonly used in the industry by most devs out there. This project was done to learn and test out these libraries.

### Key Features
- Fetches data from the [Rick and Morty API](https://rickandmortyapi.com/)
- Caches the data
- Updates UI by fetching data from a ViewModel that in turn receives it from a Repository
- Implements dependency injection
- Uses Paging

### Tech stack
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - Flow sends a stream of data that can be computed asynchronously.
- [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Provides lifecyle event of an activity or fragment.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
- [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Data Binding](https://developer.android.com/topic/libraries/data-binding)
- [Retrofit](https://github.com/square/retrofit) - Provides REST api communication.
- [OkHttp](http://square.github.io/okhttp/)
- [Gson](https://github.com/google/gson) - Converts Java Objects to JSON and vice versa.
- [Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient image loading library for Android

## Screenshots
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/9c7ab424-9e8c-49e8-9af4-3b80d80076f3" width="200" alt="Splash Screen">
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/6ac2850e-87e4-46f8-94c7-da2d3c516ad1" width="200" alt="Character List Screen">
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/09f8b2c3-b557-4b2c-a52f-140d283593ff" width="200" alt="Character Details Screen">


## Getting Started
These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites
- [Android Studio](https://developer.android.com/studio)
- Required [libraries](https://developer.android.com/studio/install#64bit-libs) for 64-bit Linux machines
- Android SDK
- Java 1.8

### Installation
1. Clone the repository by pasting the following command into your terminal:
```bash
   git clone git@github.com:sadman1148/Rick-and-Morty-Character-Viewer.git
```
2. Open the project in Android Studio and let it sync.
3. Connect a physical device or build a virtual device with the AVD manager.
4. Run the app.

### Usage
1. Browse the character list.
2. Tap on any character to see details about that character.


## Contribution
I welcome contributions from the community. To contribute to this project, follow these steps:

1. Fork this repository.
2. Create a new branch for your feature or bug fix: git checkout -b feature/your-feature-name
3. Make your changes and commit them: git commit -m 'Added a new feature'
4. Push to your branch: git push origin feature/your-feature-name
5. Create a pull request on this repository.


## Contact
Feel free to contact me on my [LinkedIn](https://www.linkedin.com/in/sadman-alam-impulse/) profile.
