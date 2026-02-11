Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "OrangeHRM"

 # Scenario Outline: Login with correct credentials
  #  Given user is on login page
   # When user enters username "<username>"
  #  And user enters password "<password>"
   # And user clicks on Login button
  #  Then user gets the title of the home page
 #   And page title should be "Secure Page page for Automation Testing Practice"
    
	# Examples:
	#  |username|password|
	#  |Admin|admin123|
	#  |student|Password1|
