# Throttling Scenario

Throttling pattern focus on the controlled consumption of resources used by an instance of an application, an individual tenant or an entire service.

Varying load overtime on an app can be from various reason

* Total active users
* Type of activity done by users
* Expensive computational task

This araises a situation when processing requirements of the system **exceeds** the capacity of the resources available resulting in poor performance and even failure. 