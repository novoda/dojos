# Reactive State

This workshop covers the following topics:
- cold vs. hot observables
- action driven vs. state driven design
- combining multiple data streams 

The example code migrates an existing action driven design to a state driven design. Best would be to checkout each commit and discuss the changes with the audience.

* 0f6088a Improve readability
* 6222b8d Replace state and listener with exposed state pipeline
* dc7f6f5 Merge add and remove subscription pipelines
* 7d07086 Migrate removal of a subscription to a long living pipeline
* 004b585 Introduce AddSubscriptionUseCase and use it when adding a subscription
* cb6a053 Replace action callbacks with state change event
* b5da46c Migrate data structure to Map<SavedSearch,Boolean>
* 1d5b2c4 Migrate add subscription pipeline to hot observable
* f6314c8 Use state pipeline when adding a subscription
* 25cd868 Introduce state pipeline
* 25ab63b Add readme
* b301f31 Initial commit reactive state

