Feature: Verify Ethereum Technical info

  Scenario: Verify Ethereum Technical info from Cryptocurrency Info service
    Given I retrieve Ethereum info
    Then I see logo url for "ETH" as
      |https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png|
    And I see Technical doc url for "ETH" as
      |https://github.com/ethereum/wiki/wiki/White-Paper|
    And I see the currency symbol as "ETH"
    And I see the data for "ETH" as "2015-08-07T00:00:00.000Z"
    And I see "mineable" tag available for "ETH"