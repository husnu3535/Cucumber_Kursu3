  Feature: Entrance Exam  Functionality

    Background:
      Given Navigate to basqar
      When Enter username and password and click login button
      Then User should login successfuly

    Scenario Outline: Create Entrance Exams
      And Click on the element in the left Nav
        | EntranceExams  |
        | setup2         |
        | EntranceExams2 |

      And Click on the element in the Dialog
        | createButton |

      And User sending the keys in Dialog content
        | nameInput | <ExamName>|

      And Click on the element in Form Content
        | AcademicPeriod         |
        | <AcademicPeriodOption> |
        | gradeLevel             |
        | <gradeLevelOption>     |
      And Click on the element in the Dialog
        | saveButton |

      And Success message should be displayed

      And Click on the element in the left Nav
        | EntranceExams  |
        | setup2         |
        | EntranceExams2 |


      And User Delete item from Dialog
        | <ExamName> |

      And Success message should be displayed

      Examples:
        | ExamName           | AcademicPeriodOption | gradeLevelOption |
        | Math exam is1111   | AcademicYear         | gradeNumber      |
        | IT exam is1111     | AcademicYear         | gradeNumber      |
        | Oracle exam is1111 | AcademicYear         | gradeNumber      |
        | Math exam  is1111  | AcademicYear         | gradeNumber      |












      # TODO yukarıdaki akademik ve Grade Level option için academicPeriod2  ve gradeLevel1,3,4  bulunup exapmple koyulacak