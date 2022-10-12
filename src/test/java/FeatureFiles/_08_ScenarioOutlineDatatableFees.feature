#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Delete Functionality

   Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

 Scenario Outline: Create a Fee, delete Fee
   And Click on the element in the left Nav
     | setup      |
     | parameters |
     | fees       |

   And Click on the element in the Dialog
     | createButton |

   And User sending the keys in Dialog content
     | nameInput       | <nameInputOption>   |
     | codeInput       | <codeInputOption>   |
     | ıntegrationCode | <ıntegrationOption> |
     | prioarity       | <priorityOption>    |

   And Click on the element in the Dialog
     | saveButton |

   And Success message should be displayed

   And User Delete item from Dialog
     | <nameInputOption> |


   And Success message should be displayed


   Examples:
     | nameInputOption | codeInputOption | ıntegrationOption | priorityOption |
     | emre355         | 111212          | 123457            | 4534542        |
     | osman355        | 223545          | 23455             | 32523423       |
     | erdinç355       | 333657          | 656756            | 3242352        |
     | tarık355        | 445433          | 67454             | 67686564       |
     | huseyin355      | 557675          | 967654            | 3244657        |














