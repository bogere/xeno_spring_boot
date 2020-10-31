/**
 * 
 */
package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author goldsoft25
 *
 */

@RestController
public class ProductServiceController {
   //we used HashMap to store the Product. Note that we used a POJO class as the 
	//product to be stored. 
	private static Map<String,Product> productRepo = new HashMap<>();
	static {
	  Product honey = new Product();
	  honey.setId("1");
	  honey.setName("Honey");
	  productRepo.put(honey.getId(), honey);
	  
	  Product almond = new Product();
	  almond.setId("2");
	  almond.setName("Almond");
	  productRepo.put(almond.getId(), almond);
	  
	}
	
	//Here, the request URI is /products and it will return the list of products from HashMap repository. 
	//The default HTTP request method is GET. This method does not require any Request Body.
	@RequestMapping(value="/products")
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}
	
	//POST API.
	//Here, the request URI is /products, and it will return the String after storing the product into HashMap repository.
	@RequestMapping(value="/products" , method=RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product){
		  productRepo.put(product.getId(), product);
		  return new ResponseEntity<>("Product is created sucessful", HttpStatus.CREATED);
	}
	
	//The HTTP PUT request is used to update the existing resource.
	//Here the request URI is /products/{id} which will return the String after a the product into a HashMap repository. 
	//Note that we used the Path variable {id} which defines the products ID that needs to be updated.
	@RequestMapping(value= "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);
		return new ResponseEntity<>("Updated the product successful", HttpStatus.OK);
	}
	
	//The HTTP Delete request is used to delete the existing resource. 
	//The request URI is /products/{id} and it will return the String after deleting the product from HashMap repository.
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
		productRepo.remove(id);
		return new ResponseEntity<>("Product is deleted successful", HttpStatus.OK);
	}
	
}
