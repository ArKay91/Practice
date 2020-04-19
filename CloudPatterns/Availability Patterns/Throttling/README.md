# Throttling Scenario

Throttling pattern focus on the controlled consumption of resources used by an instance of an application, an individual tenant or an entire service. SLA can be maintained even with an increase in demand placed on resources.

Varying load overtime on an app can be from various reason

* Total active users
* Type of activity done by users
* Expensive computational task

## Problem

This arises a situation when processing requirements of the system **exceeds** the capacity of the resources available resulting in poor performance and even failure. Chances of not meeting SLA's.

## Solution

### Strategy depending on business goals

* Auto scaling to match the provisioned resources to the user at any given time.
    - Can consistently meet user demand by optimizing running costs.
    - Auto scaling can trigger the provisioning of additional resource and is not immediate. If demand grows quickly there is a chance of resource deficit.

Extending the auto scaling feature we could impose a limit on resources to be used for every application, and throttle them when limit is reached. Throttle requests when usage exceeds threshold will enable systems to continue functioning and meet SLA's. Monitoring resource usage from a system can be helpful to achieve metrics.

### Throttling Strategies

* Rejecting user's request on an API who already accessed n times/sec over period of time. For this we need our system to meter the usage of resources for each tenant or user running the application.

* Disabling or degrading selected non-essential services so that essential services can run unimpeded with sufficient resources. Example an application with streaming video output could switch to lower resolution.

* Load leveling on services can be established so that we can smooth the number of requests over period of time. Considering multi-tenant environments this could cause performance hit on evert tenant. Mapping to business goals to achieve priority SLA's of specific tenants, we could have the requests of these tenants executed first. Requests from other tenants can be queued and executed later. Patterns like Priority Queue and Queue-based load leveling patterns can be used.

* Lower priority applications or tenants could be identified to defer operations by suspending or limiting (per tenant ?) usage. Information to tenant that system is busy and that operation should be tried later.

* To prevent API from overwhelming by too many requests, Amazon API Gateway uses *Token Bucket Algorithm* where token resemble a request. API Gateway provides option to enable throttling feature with configurable rate measure (requests per second) and burst measure (max requests in bucket or bucket size) for steady state rate on all API's. When exceeded fails the requests and returns Client error **429 Too many requests**. Client can be built intelligent enough to store those requests and process at a lower limit by complying the API Gateway throttling limits. 

> Notes generated from https://docs.microsoft.com/en-us/azure/architecture/patterns/throttling and https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-request-throttling.html