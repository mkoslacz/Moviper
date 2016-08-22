# Moviper

### A [Mosby](https://github.com/sockeqwe/mosby) based [VIPER](https://www.objc.io/issues/13-architecture/viper/) library for Android

## Why Moviper?

You got tired because of fact that your Activities and Fragments were becoming god classes, so you have migrated to MVP. Now you're tired of your god-class presenters and you just want to stop continuously wondering if you should pass a context to your presenters and make them platform-dependent and harder to mock and test, or maybe you should let your view-activity manage the system connected work. That's why you're here. My Android VIPER interpretation allows you keep your code clean, neat, and more [SRP](https://en.wikipedia.org/wiki/Single_responsibility_principle) with minimal effort.

### OK, but for every screen I have to create so many files!

To avoid manually creating all VIPER class files and managing their dependencies every time you want to create a new screen I created a generator that does all of necessary work for you. You can find it [here](https://github.com/mkoslacz/MoviperTemplateGenerator).

### Great! But I'm used to go with Mosby. What about all of its goodies?

You are able to use all of the Mosby's MVP Views with Moviper. MvpFragment, MvpLceActivity, ViewStateFragment etc. are fully compatibile with Moviper presenters.

## Dependency

I haven't yet deployed the library to any repo, so for now you will have to do a `git clone` and manually link the library to your project like [this](http://stackoverflow.com/a/31366602/3898686). I will deploy the library very soon.

## Getting started

Just create a VIPER files set using [Moviper Template Generator](https://github.com/mkoslacz/MoviperTemplateGenerator), fill up the contract, generate missing methods using Android Studio autofix
and implement them. Most probably you will want to check out a sample module provided in this repository to see how to use Moviper.

## Examples

Just check out the sample module in this repo.

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