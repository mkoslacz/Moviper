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
