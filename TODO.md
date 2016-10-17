#Viper-framework TODOs:
 -  add helper methods to BasePresenters, Interactors etc: ifViewIsAttachedDo( () -> {actions});
 -  learn & implement Dagger2 Viper injection (to use in example and maybe to remove passing
 activity through presenter to let it be android-free. another (no-dagger) option is to pass
 newly created  routing to presenter constructor)
 -  add lifecycle driven version of contract
 -  learn & implement Viper testing using Dagger & Mocks
 -  add better docs for Viper framework (Mvp, Perv, Wipe, Viper use cases etc)
 -  create super rx versions of base classes
 -  create reasonable samples of lib usage (basic, rx, tests with dagger)
 -  create non-ViewHelper versions of Perv and Viper
 -  extract Viper framework to separate library
 -  create Android Studio plugin for creating appropriate classes and interfaces set
    - choosing root viper dir
    - choosing view name
    - choosing framework (Mvp, Perv, etc.) and displaying this use-case description
    - for Viper and Perv - choosing Activity or Fragment base
    - for Viper and Perv - choosing if ViewHelper should be included