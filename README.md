### tdd-shopping-cart-gcp

 - follow tdd development approach
 - experiment with micronaut library in place of spring-boot
 - experiment deployment to gcp as containerized application

### AC 

Develop an API to request against shopping cart, 

- Given that I a new shopper, when I begin shopping, then I expect my cart to be empty.
- Given I have an empty cart, when I add an Item, then I expect to the price reflect the sum of all the Items in my cart.
- Given I have cart with one item, when I add more of that item, then I expect to see its quantity update on the cart.
- Given I have an empty cart, when I add items, then I expect it to see an itemized list of the items along with their price and quantity.
- Given I have a cart with items that are not on sale, when I add an item that's on sale, I expect to see it highlighted.
- Given I have a cart with items, when I remove an item, then I expect the cart to display the updated itemized list.
- Given I have one item in my cart with a quantity of 3, when I remove one, then I expect the cart to have 2 of that item.
