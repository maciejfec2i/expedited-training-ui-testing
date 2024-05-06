@DragAndDropTests
Feature: When dragging and dropping elements

  @DragAndDropTest1
  Scenario: the order of elements should be correct
    Given the user is on the Drag and Drop page
    When they drag and drop element "A" over element "B"
    Then the elements should be as follows
      | element-name     | element-column |
      | A                | column-b       |
      | B                | column-a       |