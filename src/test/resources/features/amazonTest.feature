Feature: Test
  Scenario: Delivery location existence on amazon

    Given User is on  "Home Page"
    When User clicks on deliverToButton from the "module" that has opened and checks if "Poland" is present
    Scenario: Delivery location confirming select on amazon
      Given User is on  "Home Page"
      When User clicks on deliverToButton from the "module" that has opened and completes the US zip code field with "36104" confirming its choice
      Then On "Home Page" the user should see the location of delivery set to "Montgomery 36104"
      Scenario: Delivery location confirming select for item page
        Given User is on  "Home Page"
        When User clicks on deliverToButton from the "module" that has opened and chooses country at index "3"
        Then User goes to the Headsets category and clicks on any item to go to its page
        And On the "Item Page" user verifies if the country has been selected correctly



