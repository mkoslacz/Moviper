# 2.0.3 to 2.0.4

*No changes needed*

# 2.0.2 to 2.0.3

*No changes needed although migrating to splitted `injectViews()` and `bindViews()` in ViperAiViewHolder and ViperAiPassiveViewHolder is strongly recommended (see methods docs).*

# 2.0.1 to 2.0.2

From now IPC methods do not operate by default on a particular `Scheduler`. Please review your IPC streams, as in some cases this may be a breaking change. 

# 2.0.0 to 2.0.1

*No changes needed*

# 1.5.0 to 2.0.0

Library has migrated to RxJava 2.x. Change your IPC streams to be compatible with RxJava2.

# 1.3.0-alpha to 1.5.0

Library has ben split to multiple modules to avoid importing unnecessary dependencies to your project. See the [Dependency](https://github.com/mkoslacz/Moviper#dependency) paragraph of the readme to find out which ones you need.

# 1.2.0-alpha to 1.3.0-alpha

## Classes

| 1.2.0-alpha                                          | 1.3.0-alpha                                                           |
|------------------------------------------------------|-----------------------------------------------------------------------|
| BaseRouting<PresenterType>                           | BaseRouting<RelatedContext, PresenterType>                            |
| BaseRxRouting                                        | BaseRxRouting<RelatedContext>                                         |
| BaseViewHelperRouting<PresenterType, ViewHelperType> | BaseViewHelperRouting<ReleatedContext, PresenterType, ViewHelperType> |
| BaseViewHelperRxRouting<ViewHelperType>              | BaseViewHelperRxRouting<ReleatedContext, ViewHelperType>              |

## Interfaces

| 1.2.0-alpha                                          | 1.3.0-alpha                                                           |
|------------------------------------------------------|-----------------------------------------------------------------------|
| ActivityHolder                                       | ContextHolder                                                         |

## Methods

| 1.2.0-alpha                                          | 1.3.0-alpha                                                           |
|------------------------------------------------------|-----------------------------------------------------------------------|
| ActivityHolder#getActivity()                         | ContextHolder#getContext()                                            |
| CommonViperRouting#isActivityAttached()              | CommonViperRouting#isContextAttached()                                |
| CommonViperRouting#getActivity()                     | CommonViperRouting#getRelatedContext()                                |

# 1.1.0-alpha to 1.2.0-alpha

## Classes

| **1.1.0-alpha**                 | **1.2.0-alpha**           |
|---------------------------------|---------------------------|
| MvpActivity                     | ViperActivity             |
| MvpLceActivity                  | ViperLceActivity          |
| MvpLceViewStateActivity         | ViperLceViewStateActivity |
| MvpViewStateActivity            | ViperViewStateActivity    |
| MvpFragment                     | ViperFragment             |
| MvpLceFragment                  | ViperLceFragment          |
| MvpLceViewStateFragment         | ViperLceViewStateFragment |
| MvpViewStateFragment            | ViperViewStateFragment    |
| PervActivityBasePresenter       | removed                   |
| PervActivityBaseRxPresenter     | removed                   |
| PervFragmentBasePresenter       | removed                   |
| PervFragmentBaseRxPresenter     | removed                   |
| WipeBasePresenter               | removed                   |
| WipeBaseRxPresenter             | removed                   |
| ViperActivityBasePresenter      | BasePresenter             |
| ViperActivityBaseRxPresenter    | BaseRxPresenter           |
| ViperFragmentBasePresenter      | BasePresenter             |
| ViperFragmentBaseRxPresenter    | BaseRxPresenter           |
| ActivityBaseRouting             | BaseRouting               |
| ActivityBaseRxRouting           | BaseRxRouting             |
| ActivityBaseViewHelperRouting   | BaseViewHelperRouting     |
| ActivityBaseViewHelperRxRouting | BaseViewHelperRxRouting   |
| FragmentBaseRouting             | BaseRouting               |
| FragmentBaseRxRouting           | BaseRxRouting             |
| FragmentBaseViewHelperRouting   | BaseViewHelperRouting     |
| FragmentBaseViewHelperRxRouting | BaseViewHelperRxRouting   |

## Interfaces

|** 1.1.0-alpha**                    | **1.2.0-alpha**             |
|------------------------------------|-----------------------------|
| MoviperInteractor                  | ViperInteractor             |
| MoviperRxInteractor                | ViperRxInteractor           |
| MoviperPresenter                   | ViperPresenter              |
| MoviperActivityPresenterForRouting | ViperPresenterForRouting    |
| MoviperFragmentPresenterForRouting | ViperPresenterForRouting    |
| MoviperPresenterForRouting         | ViperPresenterForRouting    |
| MoviperPresenterForInteractor      | ViperPresenterForInteractor |
| MoviperRouting                     | ViperRouting                |
| MoviperRxRouting                   | ViperRxRouting              |
| MoviperViewHelperRouting           | ViperViewHelperRouting      |
| MoviperViewHelperRxRouting         | ViperViewHelperRxRouting    |
| MoviperViewHelper                  | ViperViewHelper             |

## Methods

| **1.1.0-alpha**                                                                                                                         | **1.2.0-alpha**                                                                                                      |
|-----------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| MoviperActivityPresenterForRouting#createRouting(Activity activity) MoviperFragmentPresenterForRouting#createRouting(Fragment fragment) | ViperPresenterForRouting#createRouting()                                                                             |
| MoviperPresenterForRouting#isRoutingAttached()                                                                                          | removed                                                                                                              |
| MoviperPresenterForInteractor#isInteractorAttached()                                                                                    | removed                                                                                                              |
| MoviperRouting#attachPresenter(PresenterType presenter)                                                                                 | ViperRouting#attach(ActivityHolder activity, PresenterType presenter) ViperRxRouting#attach(ActivityHolder activity) |
| MoviperRouting#detachPresenter() MoviperRxRouting#onPresenterDetach()                                                                   | CommonViperRouting#detach(boolean retainInstance)                                                                    |
| Interactor#attachPresenter()                                                                                                            | ViperInteractor#attach(PresenterType presenter) ViperRxInteractor#attach()                                           |
| Interactor#detachPresenter() Interactor#onPresenterDetach()                                                                             | CommonViperInteractor#detach(boolean retainInstance)                                                                 |                                                                                                                          | 1.2.0-alpha                                                                                                          |
|-----------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| MoviperActivityPresenterForRouting#createRouting(Activity activity) MoviperFragmentPresenterForRouting#createRouting(Fragment fragment) | ViperPresenterForRouting#createRouting()                                                                             |
| MoviperPresenterForRouting#isRoutingAttached()                                                                                          | removed                                                                                                              |
| MoviperPresenterForInteractor#isInteractorAttached()                                                                                    | removed                                                                                                              |
| MoviperRouting#attachPresenter(PresenterType presenter)                                                                                 | ViperRouting#attach(ActivityHolder activity, PresenterType presenter) ViperRxRouting#attach(ActivityHolder activity) |
| MoviperRouting#detachPresenter() MoviperRxRouting#onPresenterDetach()                                                                   | CommonViperRouting#detach(boolean retainInstance)                                                                    |
| Interactor#attachPresenter()                                                                                                            | ViperInteractor#attach(PresenterType presenter) ViperRxInteractor#attach()                                           |
| Interactor#detachPresenter() Interactor#onPresenterDetach()                                                                             | CommonViperInteractor#detach(boolean retainInstance)                                                                 |