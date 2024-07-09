Feature: Login

@Sanity
Scenario: Successful login with valid credential

         Given User launch chrome browser
         When User opens URL "https://admin-demo.nopcommerce.com/login"
         And User enters email as "admin@yourstore.com" and password as "admin"
         And Click login button
         Then Page title should be "Dashboard / nopCommerce administration"
         When User click on logout link
         Then Page title should be "Your store. Login"
         And close browser

@regression
Scenario Outline: Successful login with valid credential using DDT
 
         Given User launch chrome browser
         When User opens URL "https://admin-demo.nopcommerce.com/login"
         And User enters email as "<email>" and password as "<pass>"
         And Click login button
         Then Page title should be "Dashboard / nopCommerce administration"
         When User click on logout link
         Then Page title should be "Your store. Login"
         And close browser  
 
 Examples: 
         
|email|pass|
|admin@yourstore.com|admin|
|test@store.com|admin|               