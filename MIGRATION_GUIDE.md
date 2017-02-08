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