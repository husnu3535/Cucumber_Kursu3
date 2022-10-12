Feature: Entrance Exam  Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Create Entrance Exams
    And Click on the element in the left Nav
      | EntranceExams  |
      | setup2         |
      | EntranceExams2 |

    And Click on the element in the Dialog
      | createButton |

    And User sending the keys in Dialog content
      | nameInput | mad34452 |

    And Click on the element in Form Content
      | AcademicPeriod |
      | AcademicYear   |
      | gradeLevel     |
      | gradeNumber    |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And Click on the element in the left Nav
      | EntranceExams  |
      | setup2         |
      | EntranceExams2 |


    And User Delete item from Dialog
      |mad34452|

    And Success message should be displayed











