@US06

Feature: As a data consumer, I want UI and DB book categories match.

  @db @ui  @wip
  Scenario: verify book categories with DB
    Given I log in as a librarian
    When I navigate to the "Books" page
    And I take all book categories in UI
    And I execute a query to get book categories
    Then verify book categories must match the book_categories table from DB