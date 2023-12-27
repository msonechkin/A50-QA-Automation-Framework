Feature: Login Test
  Scenario: Login Test with correct credentials
    When I login as user in Koel with "andrii.banak@testpro.io" and "OknwxILOM2B3$"
    Then I should be authorized in home page