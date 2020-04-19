# Throttling Scenario

Throttling pattern focus on the controlled consumption of resources used by an instance of an application, an individual tenant or an entire service. SLA can be maintained even with an increase in demand placed on resources.

Varying load overtime on an app can be from various reason

* Total active users
* Type of activity done by users
* Expensive computational task

This arises a situation when processing requirements of the system **exceeds** the capacity of the resources available resulting in poor performance and even failure. Chances of not meeting SLA's.

### Strategy depending on business goals

* Auto scaling to match the provisioned resources to the user at any given time.
    - Can consistently meet user demand by optimizing running costs.
    - Auto scaling can trigger the provisioning of additional resource and is not immediate. If demand grows quickly there is a chance of resource deficit.
