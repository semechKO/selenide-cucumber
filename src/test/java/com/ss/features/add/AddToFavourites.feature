Feature: AddToFavourites
  This feature checks basic addToFauvorites actions on ss.com

  @only
  Scenario Outline: Simple addToFavourites test without category screen and ascending added items

    Given click on "<title>" title
    And save first item link as "itemLink"
    And click on the first item
    And check that add to favourite is blue

    And add first item to favourites
    Then check that add to favourites is grey
    Then check that memo count is <count>

    And go to memo
    Then check that memo items count is <count>
    Then check that first item link is in items

    Examples:
      | title              | count |
      | Texts translations | 1     |
      | Acquaintances      | 2     |
      | Dogs, puppies      | 3     |


  Scenario Outline: Simple addToFavourites test with category screen.

    Given go to memo
    Given remove favourite items
    Given go to main page
    Given click on "<title>" title
    And click on the first category
    And save first item link as "itemLink"

    And click on the first item
    And check that add to favourite is blue

    And add first item to favourites
    Then check that add to favourites is grey
    Then check that memo count is 1

    And go to memo
    Then check that memo items count is 1
    Then check that first item link is in items

    Examples:
      | title     |
      | Phones    |
      | Footwear  |
      | Computers |

  Scenario Outline: Add several items to favourite

    Given go to memo
    Given remove favourite items
    Given go to main page
    Given click on "<title>" title
    And click on the first category
    And save all items links to list

    And add items to favourites
    Then check that memo count is <count>

    And go to memo
    Then check that memo items count is <count>
    Then check that links list are equals

    Examples:
      | title | count |
      | Cars  | 30    |