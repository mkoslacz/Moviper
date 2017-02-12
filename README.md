# Moviper

### A [Mosby](https://github.com/sockeqwe/mosby) based [VIPER](https://www.objc.io/issues/13-architecture/viper/) library for Android

## Why Moviper?

You got tired because of fact that your Activities and Fragments were becoming god classes, so you have migrated to MVP. Now you're tired of your god-class presenters and you just want to stop continuously wondering if you should pass a context to your presenters and make them platform-dependent and harder to mock and test, or maybe you should let your view-activity manage the system connected work. That's why you're here. My Android VIPER interpretation allows you keep your code clean, neat, and more [SRP](https://en.wikipedia.org/wiki/Single_responsibility_principle) with minimal effort.

### OK, but for every screen I have to create so many files!

To avoid manually creating all VIPER class files and managing their dependencies every time you want to create a new screen I created a generator that does all of necessary work for you. You can find it [here](https://github.com/mkoslacz/MoviperTemplateGenerator).

### Great! But I'm used to go with Mosby. What about all of its goodies?

Moviper has all of the Mosby's MVP Views mapped to fit VIPER requirements. Just simply replace `Mvp` with `Viper` and let the Android Studio do the autoimport for you.

For example `MvpFragment` maps to `ViperFragment`.

## Dependency

Import the Moviper module to your module gradle file.

```groovy
dependencies {
    compile 'com.mateuszkoslacz.moviper:moviper:1.3.0-alpha'
    debugCompile 'com.mateuszkoslacz.moviper:moviper-test:1.3.0-alpha' // optional testing utils
}
```

If you are upgrading Moviper you should probably check out the [Changelog](https://github.com/mkoslacz/Moviper/blob/master/CHANGELOG.md) and/or the [Migration guide](https://github.com/mkoslacz/Moviper/blob/master/MIGRATION_GUIDE.md).

## Getting started

First of all, check out the samples. I recommend starting with `sample-super-rx-ai` for Java with [RxJava](https://github.com/ReactiveX/RxJava) and `sample-super-rx-ai-kotlin` for [Kotlin](https://kotlinlang.org/) with [RxJava](https://github.com/ReactiveX/RxJava) to see the most powerful Moviper architecture classes.

After that, just create a VIPER files set in your project using [Moviper Template Generator](https://github.com/mkoslacz/MoviperTemplateGenerator), fill up the contract, generate missing methods using Android Studio autofix
and implement them. That's simple!

For more basic usage you shall check out:
- `sample` - a basic usage without [RxJava](https://github.com/ReactiveX/RxJava),
- `sample-rx` - a basic usage with [RxJava](https://github.com/ReactiveX/RxJava),
- `sample-rx-ai` - a [Butterknife](https://github.com/JakeWharton/butterknife) autoinject usage with [RxJava](https://github.com/ReactiveX/RxJava),

## Samples listing

- `sample` - a basic usage without [RxJava](https://github.com/ReactiveX/RxJava),
- `sample-independent-viper` - [independent Viper modules](#independent-vipers), not connected with any Android module,
- `sample-ipc` - [Moviper Inter-Presenter-Communication](#moviper-inter--presenter--communication)
- `sample-recyclerview` - RecyclerView with [Viper module for each ViewHolder](viper-viewholders) cell in the listing,
- `sample-rx` - a basic usage with [RxJava](https://github.com/ReactiveX/RxJava),
- `sample-rx-ai` - a [Butterknife](https://github.com/JakeWharton/butterknife) autoinject usage with [RxJava](https://github.com/ReactiveX/RxJava),
- `sample-rx-rdp` - a sample showcasing how to use and test [Repository Design Pattern](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006#.2dqugtik2) with Moviper,
- `sample-rx-viewstate` - a sample showcasing how to use the [Mosby's Viewstate](http://hannesdorfmann.com/mosby/viewstate/) feature with Moviper,
- `sample-service` - Viper modules for Android Services,
- `sample-super-rx-ai` - pasive Views with a [Butterknife](https://github.com/JakeWharton/butterknife) autoinject,
- `sample-super-rx-ai-kotlin` - pasive Views with [Kotlin Android Extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html),
- `sample-super-rx-ai-databinding` - pasive Views with [Data Binding library](https://developer.android.com/topic/libraries/data-binding/index.html).

## Advanced features

### Args Bundle

You can easily pass extras from your Activity or Fragment to the presenter using Moviper Args Bundle. You can check out how to use it in the Sample's `FullscreenPhotoPresenter` [constructor and its call](https://github.com/mkoslacz/Moviper/blob/master/rxsample/src/main/java/com/mateuszkoslacz/moviper/rxsample/viper/presenter/FullscreenPhotoPresenter.java#L25).

### Moviper Inter-Presenter-Communication

Referenced as IPC. It's [RxJava](https://github.com/ReactiveX/RxJava) based.

##### Quickstart

Enable IPC in your `Application` class `onCreate()` method. 
```java
Moviper.getInstance().setConfig(
        new Config.Builder()
                .withPresenterAccessUtilEnabled(true) // plain IPC
                .withInstancePresentersEnabled(false) // acces to specific presenters
                .build());
```

##### Plain IPC

You can access all alive Presenters of a given class from any place in your app like this:
```java
Moviper.getInstance().getPresenters(SomePresenter.class)
        .subscribe(somePresenter -> somePresenter.someMethod(false)); // stream of all Presenters goes here
```

For readability mark your external methods in the Presenter using the `@ExternalCall` annotation.

##### Instance Presenters Access

If you set the `withInstancePresentersEnabled` in the config to true you can use Instance Presenter Access. After that you must ensure that every Presenter of given class has an unique name. To do so you have to override Presenter `String getName()` method (in default it returns "default").

After that you can access any Presenter Instance like this:

```java
Moviper.getInstance().getPresenterInstance(SomePresenter.class, "someName")
        .subscribe(somePresenter -> somePresenter.someMethod(false)); // exactly one or zero Presenters with given name and class goes here
```

### VIPER ViewHolders

For complex RecyclerView list elements and/or multiple views on RecyclerViewlist you can design your app in the way that treats every list element as a separate VIPER View with its own contract.
Generating such ViewHolders is supported in the  [Moviper Template Generator](https://github.com/mkoslacz/MoviperTemplateGenerator).
For the sample usage check out the `sample-recyclerview`.

### Autoinject Views

AutoInject (Ai) Views that allow you to skip overriding the `onCreate(...)` / `onViewCreated(..)` method. Instead, in plain Ai Views you have to provide the layout id by overriding a `getLayoutId()` method and
to perform any view injections, getting references to views etc. by overriding a `injectViews()` method. In addition, it contains the pre-baked classes, where these methods are already implemented inside of base classes for:
   - Butterknife (check out `sample-rx-ai`),
   - DataBinding  (just like in `sample-super-rx-databinding`, but not using passive views),
   - for Kotlin Android Extensions you have to use regular Ai Views (just like in `sample-super-rx-ai-kotlin`, but not using passive views).

### Passive Views

Passive Views (based on AutoInject ones) that enforces developer to create passive views, that are not aware of existence of Presenter. All communication from View to Presenter has to be done through providing Observables with given UI events. It's enforced by the fact that `getPresenter()` method of this kind of views does not return Presenter of some exact type, but as a general `ViperPresenter`, so calling any meaningful methods on it is impossible. As in the previous point, it also contains the pre baked classes for:
   - Butterknife(just like in `sample-super-rx-ai-kotlin`, but using passive views),
   - DataBinding (check out `sample-super-rx-databinding`),
   - for Kotlin Android Extensions you have to use regular AiPassive Views (check out `sample-super-rx-ai-kotlin`).

### Choosing Presenter on runtime

A `MoviperPresentersDispatcher` tool allows you to choose the View's (especially Activity) presenter on the runtime without a need of putting it to the `Bundle` with all it's limitations or switching in .
Sample launching of Activity with given presenter is available in `sample-super-rx-ai`, in `ListingRouting#startUserDetailsActivity(...)`, and adjusting Activity to be started with any presenter is showcased in `UserDetailsActivity#createPresenter()`.

### Attaching multiple presenters to the View

`ViperPresentersList` allows you to easily attach multiple presenters to the Passive Views. Sample usage is very simple and available in sample-super-rx-au in `UserDetailsActivity#createPresenter()`.

### `Service` based VIPERs

Allow you to maintain a uniform architecture between your app's views and services. It includes support for:
   - regular `Service`'s
   - `IntentService`'s

Sample usage is showcased in `sample-service`

### Independent VIPERS

Allow you to maintain a uniform architecture between your app's views and complex task objects that aren't strictly connected with any specific Android component. Sample usage available in `sample-independent-viper`.

### Test utils

Optional `moviper-test` module (see [Dependency paragraph](#dependency)) contains useful testing tools:
   - `FragmentTestRule` to perform Fragment instrumentation tests in isolation,
   - `MoviperActivityTestRule` to perform Viper Activity instrumentation tests with proper cleanup,
   - `ViewHolderTestRule` to perform Recyclerview's ViewHolder instrumentation tests in isolation,
   - `RxAndroidSchedulersOverrideRule` to override `AndroidSchedulers.mainThread()` behaviour in unit tests,
   - `ViewHolderUnitTestAcrivity` to perform Recyclerview's ViewHolder Robolectric unit tests in isolation,
   - `RecyclerViewMatcher` to match RecyclerView's contents in Espresso instrumentation tests.

Check out the test modules of the samples to check out how easy is testing with Moviper and to see various usecases of `moviper-test` module.

## Credits

This library is built on top of a great [Mosby](https://github.com/sockeqwe/mosby) library by [Hannes Dorfmann](http://hannesdorfmann.com/). Check out the [project website](http://hannesdorfmann.com/mosby/). 

I've also used a Lucas Urbas Interactor implementation idea presented in his [Search viper architecture example](https://github.com/lurbas/Search).

I have followed [Publish AAR to jCenter and Maven Central](https://gist.github.com/lopspower/6f62fe1492726d848d6d) by Lopez Mikhael to publish Moviper to jCenter.

The great thanks for the my team that helped me in Moviper development implementing my ideas under my guidance:
* [Tomasz Najda](https://github.com/tomasznajda)
* [Bartosz Wilk](https://github.com/bartoszwilk)
* [Jakub Jodelka](https://github.com/jakubjodelka)


## License
```
Copyright 2017 Mateusz Koślacz

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