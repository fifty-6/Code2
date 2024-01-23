package testNGTool;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ToSkipScript {

	@Test
	public void createAccount(){
	Assert.assertEquals("pune","Deccan");
	System.out.println("Created");
	}
	
      @Test(dependsOnMethods="createAccount")
	public void deleteAcount(){
	System.out.println("deleted");
	}
      
      @Test(dependsOnMethods="createAccount")
      public void editAccount() {
    	  System.out.println("Edited");
      }
      
      @Test
      public void anythingnTest() {
    	  System.out.println("Anything but not dependdent on create account");
      }
      
}
