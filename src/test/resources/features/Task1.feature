Feature: Tasks1 - Convert currencies to Bolivian Boliviano

Scenario: Convert cryptocurrencies to Bolivian Boliviano
  Given I retrieve cryptocurrencies
  Then I convert "1000" amount to Bolivian Boliviano "BOLI" for below currencies
    |    BTC         |
    |    USDT        |
    |    ETH         |