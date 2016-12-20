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

```groovy
dependencies {
    compile 'com.mateuszkoslacz.moviper:moviper:1.2.0-alpha'
}
```

If you are upgrading Moviper you should probably check out the [Changelog](https://github.com/mkoslacz/Moviper/blob/master/CHANGELOG.md) and/or the [Migration guide](https://github.com/mkoslacz/Moviper/blob/master/MIGRATION_GUIDE.md).

## Getting started

First of all, check out the samples. After that, just create a VIPER files set using [Moviper Template Generator](https://github.com/mkoslacz/MoviperTemplateGenerator), fill up the contract, generate missing methods using Android Studio autofix
and implement them. Most probably you will want to check out a sample module provided in this repository to see how to use Moviper. You have two flavours of Moviper. The "regular" one — to use with callbacks, and the Rx one, to use with RxJava.

## Advanced features

### Args Bundle

You can easily pass extras from your Activity or Fragment to the presenter using Moviper Args Bundle. You can check out how to use it in the Sample's `FullscreenPhotoPresenter` [constructor and its call](https://github.com/mkoslacz/Moviper/blob/master/rxsample/src/main/java/com/mateuszkoslacz/moviper/rxsample/viper/presenter/FullscreenPhotoPresenter.java#L25).

### Moviper Inter-Presenter-Communication (IPC) (RxJava)

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

## Examples

For the basic usage just check out the `sample-rx` (or `sample`, if you aren't familiar with [RxJava](https://github.com/ReactiveX/RxJava)) module in this repo. Most of samples include showcases of test scenarios for given Moviper usecases.

More advanced usage:
- Inter-Presenter-Communication — `sample-ipc`,
- VIPER ViewHolders - `sample-recyclerview`,
- Repository Design Pattern usage in Interactors and tests - `sample-rx-rdp`
- ViewState usage - `sample-rx-viewstate`
- Activity/Fragment retaining presenter - `sample-rx-presenter`

## Credits

This library is built on top of a great [Mosby](https://github.com/sockeqwe/mosby) library by [Hannes Dorfmann](http://hannesdorfmann.com/). Check out the [project website](http://hannesdorfmann.com/mosby/). 

I've also used a Lucas Urbas Interactor implementation idea presented in his [Search viper architecture example](https://github.com/lurbas/Search).

I have followed [Publish AAR to jCenter and Maven Central](https://gist.github.com/lopspower/6f62fe1492726d848d6d) by Lopez Mikhael to publish Moviper to jCenter.

## License
```
Copyright 2016 Mateusz Koślacz

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