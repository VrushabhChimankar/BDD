Feature: CustomerAdd
Background: Same steps for all scenarios
         Given User launch chrome browser
         When User opens URL "https://admin-demo.nopcommerce.com/login"
         And User enters email as "admin@yourstore.com" and password as "admin"
         And Click login button
         Then User can view dashboard

@Sanity
Scenario: Add New Customer
       
         When User click on customer menu
         And click on customer menu item
         And click on Add new button
         Then User can view Add new customer page
         When User enter customer info
         And click on Save button
         Then User can view confirmation message "The new customer has been added successfully."
         And close browser
         
         @regression
         Scenario: Search Customer by email

         When User click on customer menu
         And click on customer menu item  
         And Enter customer Email
         When Click on search button
         #Then User should found email in search table
         And Close browser
         
         @regression
         Scenario: Search Customer by Name
         
         When User click on customer menu
         And click on customer menu item 
         And Enter customer Firstname
         And Enter customer Lastname
         When Click on search button
         And Close browser