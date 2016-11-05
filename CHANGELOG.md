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
