Feature: Content Rating
  In order to express my opinion about content
  As a user
  I want to be able to rate a piece of content

Scenario: Average ~ Out of 5
  Given a piece of content has received many ratings between 0 and 5
  When I view that content
  Then I want to see the average rating
