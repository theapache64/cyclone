![](cover.jpeg)

# cyclone

![buildStatus](https://img.shields.io/github/workflow/status/theapache64/cyclone/Java%20CI%20with%20Gradle?style=plastic)
![latestVersion](https://img.shields.io/github/v/release/theapache64/cyclone)
<a href="https://twitter.com/theapache64" target="_blank">
<img alt="Twitter: theapache64" src="https://img.shields.io/twitter/follow/theapache64.svg?style=social" />
</a>

> Write JVM apps Android way

## 🛠 Installation
```groovy
implementation 'com.theapache64:cyclone:1.0.0-beta01'
```

## Story 🌲

I was just wondering would it be possible to write CLI apps like we write Android apps. By using the same structure,
tools, and the APIs.

I started the project by cloning `LiveData` API structure. I made sure that it works as expected. After that I cloned
API structures of  `ViewModel, Activity, Application, Context and Intent`. (I didn't fully clone the component, but the
minimum version to write a simple CLI app)

(By this time, you might have got why I named the project cy**clone** 😋)

## Example 🔬

### How to run the example ?

- Run the main method
- Give any username and password (length should be > 0)

### Structure 📂

The example project contains 2 modules, Core and Example. Core module contains the cloned classes (library), and the
Example module contains an example using the cloned classes.

The Example is a TODO app. It has below given features.

- Log In
- Todo Listing

### Built With 🛠️

- Coroutines 🔃
- Dagger2 🗡️
- Moshi 🔳
- Retrofit 🌐

## Directory Structure 📁

### Library

```
.
└── core
    ├── Activity.kt
    ├── Application.kt
    ├── Context.kt
    ├── extensions
    │   └── FlowExtensions.kt
    ├── InputUtils.kt
    ├── Intent.kt
    ├── livedata
    │   ├── LiveData.kt
    │   └── MutableLiveData.kt
    └── network
        ├── BaseApiResponse.kt
        ├── flow
        │   ├── FlowResourceCallAdapterFactory.kt
        │   └── FlowResourceCallAdapter.kt
        └── Resource.kt

5 directories, 12 files
```

### Example

```
.
└── example
    ├── App.kt
    ├── data
    │   ├── local
    │   ├── remote
    │   │   ├── ApiInterface.kt
    │   │   ├── login
    │   │   │   ├── LogInRequest.kt
    │   │   │   └── LogInResponse.kt
    │   │   └── todolist
    │   │       ├── TodoListRequest.kt
    │   │       └── TodoListResponse.kt
    │   └── repositories
    │       ├── TodoRepo.kt
    │       └── UserRepo.kt
    ├── di
    │   ├── components
    │   │   ├── LogInComponent.kt
    │   │   └── TodoListComponent.kt
    │   └── modules
    │       └── NetworkModule.kt
    ├── models
    ├── ui
    │   ├── login
    │   │   ├── LogInActivity.kt
    │   │   └── LogInViewModel.kt
    │   └── todolist
    │       ├── TodoListActivity.kt
    │       └── TodoListViewModel.kt
    └── utils

15 directories, 15 files
```

## ☑️ TODO 

- [ ] Add tests
- [ ] Add more features to example TODO app
- [ ] Add comments to source code
- [ ] Clone more components
- [x] Publish `core` via `maven`


## 🥼 Run tests

```shell script
./gradlew test
```

## ✍️ Author

👤 **theapache64**

* Twitter: <a href="https://twitter.com/theapache64" target="_blank">@theapache64</a>
* Email: theapache64@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.patreon.com/theapache64">
  <img alt="Patron Link" src="https://c5.patreon.com/external/logo/become_a_patron_button@2x.png" width="160"/>
</a>

<a href="https://www.buymeacoffee.com/theapache64" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160">
</a>

<a href="https://www.paypal.me/theapache64" target="_blank">
    <img src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" alt="Donation" width="160">
</a>

## 📝 License

```
Copyright © 2021 - theapache64

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

_This README was generated by [readgen](https://github.com/theapache64/readgen)_ ❤