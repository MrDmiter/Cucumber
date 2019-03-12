Feature: User open the site, logs in,
	     add product to the cart and
	     verifies total sum
Scenario: Checkout
	      Given The user opens site sees Home Page
          When User click on sign in button
          And Enters username 'gavuyabavu@digitalmail.info', password '12345' and clicks on sign in
          Then User is logged in 
          When Click on the T-Shirts page
	      And Click on the needed product 'Faded Short Sleeve T-shirts'
          Then Breadcrumbs should be '> Women>Tops>T-shirts>Faded Short Sleeve T-shirts'
          When Add product to the cart and proceed to checkout
	      Then Increase number of products in the cart and see total price is changed
          When Remove product from the cart
          Then Check the presence of the Cart is empty message
          And Close browser