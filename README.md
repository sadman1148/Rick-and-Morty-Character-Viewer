# Rick and Morty Character Viewer

<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/f0b11193-8b7c-4c90-9142-6999848f4d6a" width="250" alt="App Icon">

## Overview

The **Rick and Morty Character Viewer** is an information viewer app that does a very simple task of fetching data from an API and viewing it on the UI. It makes use of some of the latest and most popular libraries that are commonly used in the industry by most devs out there.

### Key Features

- Fetches data from the [Rick and Morty API](https://rickandmortyapi.com/) using [Retrofit](https://square.github.io/retrofit/)
- Caches the data with [OkHttp3](https://square.github.io/okhttp/)
- Uses [Livedata](https://developer.android.com/topic/libraries/architecture/livedata) to observe changes in dataset and populates RecyclerView
- Updates UI by fetching data from a ViewModel that in turn receives it from a Repository
- Uses [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation) Component to navigate
- Implements [Hilt and Dagger](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection
- Uses Paging
- Shows images with [Glide](https://github.com/bumptech/glide)

## Screenshots

<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/da6b624c-21af-4740-8370-62a7e8a73b61" width="300" alt="Splash Screen">
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/0652dbe9-c93e-4917-911e-66c31865d87a" width="300" alt="Character List Screen">
<img src="https://github.com/sadman1148/Rick-and-Morty-Character-Viewer/assets/71433330/17c3da5d-5741-47bd-80e3-1b244c9fc7db" width="300" alt="Character Details Screen">

## Getting Started

These instructions will help you set up and run the project on your local machine for development and testing purposes.

### Prerequisites

- [Android Studio](https://developer.android.com/studio)
- Required [libraries](https://developer.android.com/studio/install#64bit-libs) for 64-bit Linux machines

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
