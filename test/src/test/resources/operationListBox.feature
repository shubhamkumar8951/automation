Feature: List box operation

  #Scenario: List box operation
  #Given The url is provided
  #Then select listbox "JQuery List Box"
  #Then select "Julia" from pick list
  #Then click on add button
  
  #Scenario: Drag and Drop operation
  #Given The url is provided
  #Then select others "Drag and Drop"
  #Then select items to drag "Draggable 1" and drop into Drop here
  
  Scenario: List box operation for select
    Given The url is provided
    Then select listbox "JQuery List Box"
    Then validate following fields present in select dropdown
      | Isis     |
      | Sophia   |
      | Alice    |
      | Isabella |
      | Manuela  |
