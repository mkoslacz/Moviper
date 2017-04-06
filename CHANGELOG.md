## 2.0.2

### Breaking change

* From now IPC methods do not operate by default on a particular `Scheduler`. Please review your IPC streams, as in some cases this may be a breaking change. 

### Enhancements

* Inter-Presenter Communication (IPC):
 - from now IPC methods do not operate by default on a particular `Scheduler` (see above), 
 - error handling adapted to RxJava 2.x,
 - introduced error handler that allows you subscribe to IPC errors. By default it prints an error using `Log.e("Moviper, "IPC default error handler: ", e);`,
 - added `getPresenterInstanceOrError` method that returns `Single`,
 - fixed some bugs.
* Presenters (`CommonBasePresenter`):
 - fixed equality issues for presenters of different classes with the same name (regression introduced in `2.0.1`)
* ViperViewHolder:
 - fixed presenter detaching issue on scrolling the `RecyclerView` - presenters did not detach from a view on the recycle. 
* Bumped dependencies versions.


## 2.0.1

### Enhancement

* From now presenters have random names at default, so you can create multiple presenters of a given class without overriding `getName()` with `PresenterInstancesAccess` enabled. It's useful when you don't want to use presenter instance access on the particular class but just regular `PresentersAccessUtil`. 


## 2.0.0

### Breaking change & enhancement

Migrated Moviper to RxJava 2.x!


## 1.5.0

### Breaking change & enhancement

Library has ben split to multiple modules to avoid importing unnecessary dependencies to your project. See the [Dependency](https://github.com/mkoslacz/Moviper#dependency) paragraph of the readme to find out which ones you need.


## 1.3.0-alpha

### Breaking changes

This release introduces some breaking changes. All stuff listed below is also mentioned in the [Migration guide](https://github.com/mkoslacz/Moviper/blob/master/MIGRATION_GUIDE.md).
* Unified methods for getting context in Routings.

### Enhancements

Introduced:
* AutoInject (Ai) Views that allow you to skip overriding the `onCreate(...)` / `onViewCreated(..)` method. Instead, in plain Ai Views you have to provide the layout id by overriding a `getLayoutId()` method and
to perform any view injections, getting references to views etc. by overriding a `injectViews()` method. In addition, it contains the pre-baked classes, where these methods are already implemented inside of base classes for:
    - Butterknife,
    - DataBinding,
    - for Kotlin Android Extensions you have to use regular Ai Views.
* Passive Views (based on AutoInject ones) that enforces developer to create passive views, that are not aware of existence of Presenter. All communication from View to Presenter has to be done through providing Observables with given UI events. It's enforced by the fact that `getPresenter()` method of this kind of views does not return Presenter of some exact type, but as a general `ViperPresenter`, so calling any meaningful methods on it is impossible. As in the previous point, it also contains the pre baked classes for:
    - Butterknife,
    - DataBinding,
    - for Kotlin Android Extensions you have to use regular AiPassive Views.
* `MoviperPresentersDispatcher` tool that allows you to choose the View's (especially Activity) presenter on the runtime without a need of putting it to the `Bundle` with all it's limitations.
* `ViperPresentersList` that allows you to easily attach multiple presenters to the Passive Views.
* `Service` based VIPERs to allow you to maintain a uniform architecture between your app's views and services. It includes support for:
    - regular `Service`'s
    - `IntentService`'s
* independent VIPERS to allow you to maintain a uniform architecture between your app's views and complex task objects that aren't strictly connected with any specific Android component.
* a `moviper-test` module that contains useful testing tools:
    - `FragmentTestRule` to perform Fragment instrumentation tests in isolation,
    - `MoviperActivityTestRule` to perform Viper Activity instrumentation tests with proper cleanup,
    - `ViewHolderTestRule` to perform Recyclerview's ViewHolder instrumentation tests in isolation,
    - `RxAndroidSchedulersOverrideRule` to override `AndroidSchedulers.mainThread()` behaviour in unit tests,
    - `ViewHolderUnitTestAcrivity` to perform Recyclerview's ViewHolder Robolectric unit tests in isolation,
    - `RecyclerViewMatcher` to match RecyclerView's contents in Espresso instrumentation tests.

And added some more Javadocs

### General

* Introduced even more samples for new features:
    - sample-super-rx-ai-kotlin
    - sample-independent-viper
    - sample-ipc-ai
    - sample-rx-ai
    - sample-service
    - sample-super-rx-ai
    - sample-super-rx-ai-kotlin
    - sample-super-rx-databinding

### Internal

* Increase tests coverage, also for non-TDD libs that we base onto.
* Bumped dependencies versions:
    - RxJava to 1.2.6

### Credits

Once again, many thanks to guys that helped me in Moviper development implementing my ideas under my guidance:
* [Tomasz Najda](https://github.com/tomasznajda) - extracting moviper-test module, implementing Viper services and independent Vipers and samples for the latter,
* [Bartosz Wilk](https://github.com/bartoszwilk) - Moviper templates, some Ai Views, improving test coverage, implementing `MoviperPresetnersDispatcher`, super-rx-ai sample,
* [Jakub Jodelka](https://github.com/jakubjodelka) - Viper service sample.


## 1.2.0-alpha

### Breaking changes

This release introduces some breaking changes. All stuff listed below is also mentioned in the [Migration guide](https://github.com/mkoslacz/Moviper/blob/master/MIGRATION_GUIDE.md).
* Simplified Moviper internals to ease the troubleshooting and debugging.
* Rename some methods to make them more self-explaining.
* Removed Wipe (View-Interactor-Presenter-Entity) and Perv (Presenter-Entity-Routing-View) components as they did not add much value to the project but still needed the maintenance.
* Removed deprecated methods.

### General

* Introduced even more samples, now with VIPER testing showcases inside.

### Enhancements

* Added support for `ViewHolder`s. Now they can represent a View in a VIPER architecture. See `sample-recyclerview`.

### Internal

* Routing activity attaching moved from constructor to the routing lifecycle.
* Simplified a VIPER components lifecycle.
* Simplified a presenter architecture.
* Simplified a routing architecture.
* Bumped dependencies versions:
    - RxJava to 1.2.3
    - buildtools to 25.0.2
    - support libs to 25.1.0

### Credits

Many thanks to guys that helped me in Moviper development implementing my ideas.
* [Tomasz Najda](https://github.com/tomasznajda) - simplifying Moviper architecture,
* [Bartosz Wilk](https://github.com/bartoszwilk) - Moviper templates,
* [Jakub Jodelka](https://github.com/jakubjodelka) - Moviper samples, VIPER ViewHolders.


## 1.1.0-alpha

### General

* Change the Moviper stage of development to alpha as some API methods may change.
* Introduced completely new samples.

### Enhancements

* Added the Rx flavored version of Moviper that lacks Presenter references in Interactor and Routing.
* Added the Presenter args Bundle that allows passing arguments from Activity/Fragment extras to Routing and Interactor constructors.
* Added the Moviper Inter-Presenter-Communication tool to avoid using a bus in the mentioned communication.

### Deprecated (will be removed in the next release)

* Unnecessary Presenter `isRoutingAttached()` and `isInteractorAttached()` methods.

### Internal

* Removed the unnecessary double-purging Interactor and Routing references in Presenter.
* Fixed some improper @Nullable marks for Routing and Interactor in Presenter and ViewHelper/Context weak references in Routing, change them to @NonNull.
* Bumped dependencies versions:
    - buildtools, appcompat and sdk to 25
    - gradle to 2.2.2
    - gradle-retrolambda to 3.3.1
    - RxJava to 1.2.2
    
### Credits

* Great thanks to Jakub Jodełka ([@jakubjodelka](https://github.com/jakubjodelka)) for providing the brand new samples.
     

## 1.0.0

### Initial release
