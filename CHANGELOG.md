## 1.3.0-alpha

## Enhancements

* Introduced AutoInject (Ai) Views that allows you to skip overriding the `onCreate(...)` / `onViewCreated(..)` method but provide the layout id by overrriding `getLayoutId()` method and
 perform any view injections, getting references to views etc by overriding a `injectViews()` method. It contains the pre-baked classes, where view injections are done inside of base classes for:
    - Butterknife,
    - DataBinding,
    - for Kotlin Android Extensions you have to use regular Ai Views.
* Introduced Passive Views (based on AutoInject ones) that enforces developer to create passive views, that are not aware of existence of Presenter. All communication from View to Presenter has to be done through providing Observables with given UI events. It's enforced by the fact that `getPresenter()` method of this kind of views does not return Presenter of some exact type, but as a general `ViperPresenter`, so calling any meaningful methods on it is impossible. It also contains the pre baked classes for:
    - Butterknife,
    - DataBinding,
    - for Kotlin Android Extensions you have to use regular AiPassive Views.
* Introduced `MoviperPresentersDispatcher` tool that allows you to choose the View's (especially Activity )presenter on the runtime without a need of putting it to the `Bundle` with all it's limitations.
* Introduced `ViperPresentersList` that allows you to easily attach multiple presenters to the Passive Views.
* Introduced `Service` based VIPERs to allow you to maintain a uniform architecture between your app's views and services. It includes support for:
    - regular `Service`'s
    - `IntentService`'s
* Introduced independent VIPERS to allow you to maintain a uniform architecture between your app's views and complex task objects that aren't strictly connected with any specific Android component.
* Introduced a `moviper-test` module that contains useful testing tools:
    - `FragmentTestRule` to perform Fragment instrumentation tests in isolation,
    - `MoviperActivityTestRule` to perform Viper Activity instrumentation tests with proper cleanup,
    - `ViewHolderTestRule` to perform Recyclerview's ViewHolder instrumentation tests in isolation,
    - `RxAndroidSchedulersOverrideRule` to override `AndroidSchedulers.mainThread()` behaviour in unit tests,
    - `ViewHolderUnitTestAcrivity` to perform Recyclerview's ViewHolder Robolectric unit tests in isolation,
    - `RecyclerViewMatcher` to match RecyclerView's contents in Espresso instrumentation tests.

### General

* Introduced even more samples:
    - sample-super-rx-ai-kotlin

### Enhancements

* Added some more Javadocs

### Internal

* Increase tests coverage, also for non-TDD libs that we base onto.

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
