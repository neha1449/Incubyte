Feature: Gmail testing

Scenario: Gmail login

Given open URL
Then Enter email-id and password
Then click on compose button
Then Enter To,Subject fields
And Select Attach File Button
Then click on Send button
Then Logout account and close browser


