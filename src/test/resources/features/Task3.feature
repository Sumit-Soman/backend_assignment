Feature: Verify Info service

  Scenario: Verify correct tags and ids are fetched in Info service
    Given I retrieve currency info for first 10 Ids
    Then I see "mineable" tag available for all 10 currencies
    And I see the correct ID's retrieved for first 10 currencies