# Advanced_Android_Works

![Android](https://img.shields.io/badge/Platform-Android-green.svg)   ![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)   ![In Progress](https://img.shields.io/badge/in%20progress-true-yellow.svg) <br />
Repository that showcases Android simple yet Best Practices with Intermediate to Advanced Project Creation skills

## Contents
**#1 [AndroidAnim](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/AndroidAnim)**
<br /><br />
**#2 [AndroidDraw](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/AndroidDraw)**<br /><br />
**#3 [ContentProvider](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/ContentProvider)**
<br /><br />
**#4 [ExpressoExpress](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/ExpressoExpress)**
<br /><br />
**#5 [FirebaseGoogleSign](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/FirebaseGoogleSign)**
<br /><br />
**#6 [FlexibleFragments](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/FlexibleFragments)**
<br /><br />
**#7 [ListWidget](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/ListWidget)**
<br /><br />
**#8 [MediaPlayback](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/MediaPlayback)**
<br /><br />
**#8 [WidgetGadget](https://github.com/SyamSundarKirubakaran/Advanced_Android_Works/tree/master/WidgetGadget)**


## 1. AndroidAnim:
An app used to find the followers in Github by supplying his/her accounts user name.(**NOTE:** The app can only show 30 followers at a time since the **GitHub API** JSON Objects are restricted to 30 for an URL). <br />

**You'll Learn:**
* [Networking in Android](https://developer.android.com/training/basics/network-ops/connecting.html)
* JSON parsing
* Simple List view
* Array List and Adapters<br />

**Github URL for followers Retival:** <br />
<br />
`https://api.github.com/users/ <<User name>> /followers` <br />
<br />
**Show case:**
<br />
<p align="center">
  <img src="asserts/anim.gif">
</p>

## 2. AndroidDraw:
[In Progress](https://img.shields.io/badge/in%20progress-true-yellow.svg) <br />
A simple app that download the image from the given URL and displays it in an image view using **Picasso** library to fetch the image<br />

## 3. ContentProvider:
An app that uses the [Movies.db API](https://www.themoviedb.org/?language=en) to find the popular movies and inflate the activities with the data of those movies accordingly. <br />

**You'll Learn:**
* Working with [Movies API](https://www.themoviedb.org/?language=en)
* [Networking in Android](https://developer.android.com/training/basics/network-ops/connecting.html)
* JSON parsing
* Simple List view
* Array List and Adapters<br />

**Popular movies in the form of JSON:** <br />
<br />
`https://api.themoviedb.org/3/movie/popular?api_key= <<YOUR_API_KEY>> ` <br />
<br />
**Note:**<br />
Get your API key and place it in the strings.xml file in the resource directory.<br />
``` xml
<string name="API_Key">Your API Key</string>
```
**Show case:**<br />
<p align="center">
  <img src="asserts/content_pro.gif">
</p>

## 4. ExpressoExpress:
An app that uses the [Movies.db API](https://www.themoviedb.org/?language=en) to find the popular movies and Top rated movies in realtime and inflate the activities with the data of those movies accordingly. <br />

**You'll Learn:**
* Working with [Movies API](https://www.themoviedb.org/?language=en)
* [Networking in Android](https://developer.android.com/training/basics/network-ops/connecting.html)
* JSON parsing
* Scrolling view
* Picasso
* Bottom Tabbed Activity<br />

**Popular movies in the form of JSON:** <br />
<br />
`https://api.themoviedb.org/3/movie/popular?api_key= <<YOUR_API_KEY>> ` <br />
<br />
`https://api.themoviedb.org/3/movie/top_rated?api_key= <<YOUR_API_KEY>> ` <br />
<br />
**Note:**<br />
Get your API key and place it in the strings.xml file in the resource directory.(NOTE: Marked as TODO in strings.xml file)<br />
``` xml
<string name="API_Key">Your API Key</string>
```
**Show case:**<br />
<p align="center">
  <img src="asserts/test.gif">
</p>

## 5. FirebaseGoogleSign:
An app that uses the [SQLite](https://www.sqlite.org/) database to store data premanently and retrieve it when ever necessary.<br />

**You'll Learn:**
* Working with [SQLite Databases](https://www.sqlite.org/)
* [SQL Query](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
* Data Presistence
* List View Updation after specific operation on the Database<br />

**Base Understanding for:** <br />
* Content Providers
* Working with URIs to query out from Database

**Note:**<br />
Mainly focuses on Data Presistence.

**Show case:**<br />
<p align="center">
  <img src="asserts/signin.gif">
</p>

## 6. FlexibleFragments:
An app that illustrates the working of android lifecycle and which preserves data between screen orientation changes using onSavedInstanceStates and callbacks.<br />

**You'll Learn:**
* Short term Data presistence
* Lifecycle callbacks
* onSavedInstanceState method to preserve data between orientation shift that leads to data teardowns.<br />

**Show case:**<br />
<p align="center">
  <img src="asserts/frag_tab.gif">
  <img src="asserts/frag_phone.gif">
</p>

## 7. ListWidget:
An app that illustrates how to manage users Preferences for you app and also helps to store users preference so that those preferences remainds default even when the app is relaunched.<br />

**You'll Learn:**
* Short term Data presistence
* Setting up Settings Activity
* Check box Preferences, List Preferences and Edit text Preferences.
* Handling and Managing user's preferences so that UI can be changed accordingly.<br />

**Show case:**<br />
<p align="center">
  <img src="asserts/widget_list.gif">
</p>

## 8. MediaPlayback:
An app that uses the [Movies.db API](https://www.themoviedb.org/?language=en) to find the popular movies,Top rated,Now playing and Up coming movies in realtime and inflate the activities with the data of those movies accordingly. <br />

**You'll Learn:**
* Working with [Movies API](https://www.themoviedb.org/?language=en)
* [Networking in Android](https://developer.android.com/training/basics/network-ops/connecting.html)
* JSON parsing
* Scrolling view
* Picasso
* Bottom Navigation Bar
* Grid View
* Play videos in YouTube using implicit intents
* Favorite movies tracking
* Content Providers
* SQLite Databases
* Working with URIs
* Using share Intent
* Handle Requests in absence of network
* Offline Storage of favorite movies
* Bug fix<br />

**Show case:**<br />
<p align="center">
  <img src="asserts/exoplayer.gif">
</p>

## 9. WidgetGadget:
An app that uses the [Movies.db API](https://www.themoviedb.org/?language=en) to find the popular movies,Top rated,Now playing and Up coming movies in realtime and inflate the activities with the data of those movies accordingly. <br />

**You'll Learn:**
* Working with [Movies API](https://www.themoviedb.org/?language=en)
* [Networking in Android](https://developer.android.com/training/basics/network-ops/connecting.html)
* JSON parsing
* Scrolling view
* Picasso
* Bottom Navigation Bar
* Grid View
* Play videos in YouTube using implicit intents
* Favorite movies tracking
* Content Providers
* SQLite Databases
* Working with URIs
* Using share Intent
* Handle Requests in absence of network
* Offline Storage of favorite movies
* Bug fix<br />

**Show case:**<br />
<p align="center">
  <img src="asserts/widget_pic.gif">
</p>
