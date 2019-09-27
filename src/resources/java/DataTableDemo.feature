Feature: Datatable Demo
Scenario: Login
Given User must be registered
When User performs login using
|username||password|
|tutorial||tutorial|
|mercury||mercury|
Then user lands up in home page
