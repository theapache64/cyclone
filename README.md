# cyclone 🌀

I tried to implement MVVM with *Android Architecture Components* in a **CLI app**. Just for fun 😋

*NOTE: This project is under active development 🚧*

## Install ⌨️

```groovy
implementation 'com.theapache64:cyclone:1.0.0-alpha01'
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

### Directory Structure 📁

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

## TODO ☑️

- [ ] Add tests
- [ ] Add more features to example TODO app
- [ ] Add comments to source code
- [ ] Clone more components
- [x] Publish `core` via `maven`

## Author ✍️

- theapache64 