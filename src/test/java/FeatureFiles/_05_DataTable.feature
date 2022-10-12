Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario: Create Country
    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | createButton |

    And User sending the keys in Dialog content
      | nameInput | ismetCoun21 |
      | codeInput | 121233      |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User Delete item from Dialog
      | ismetCoun21 |

    And Success message should be displayed

  Scenario: Create a Nationality
    And Click on the element in the left Nav
      | setup       |
      | parameters  |
      | nationality |

    And Click on the element in the Dialog
      | createButton |

    And User sending the keys in Dialog content
      | nameInput | ismetNat21 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User Delete item from Dialog
      | ismetNat21 |

    And Success message should be displayed

  Scenario: Create a Fee, delete Fee
    And Click on the element in the left Nav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | createButton |

    And User sending the keys in Dialog content
      | nameInput       | husnu31   |
      | codeInput       | 123456789 |
      | ıntegrationCode | 246642    |
      | prioarity       | 123456788 |

    And Click on the element in the Dialog
      | saveButton |

    And Success message should be displayed

    And User Delete item from Dialog
      | husnu31 |

    And Success message should be displayed




    #  Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #  DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.