package com.test.springboot.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Customer  implements Serializable {

        
    public Customer(){
    }


	@Id
	@Column(name = "customerId")
    private Integer customerId;
    
    
        
  	@Column(name = "description")
    private String description;
        
  	@Column(name = "customerName")
    private String customerName;
        
       	public void setCustomerId ( Integer customerId ){
       		 this.customerId = customerId;
    }
   
       	public Integer getCustomerId ( ){
       		 return this.customerId;
     		 }
    
            	public void setDescription ( String description ){
       		 this.description=description;
      		 }
        	public void setCustomerName ( String customerName ){
       		 this.customerName=customerName;
      		 }
       
          	public String getDescription ( ){
       		 return this.description;
     		 }
        	public String getCustomerName ( ){
       		 return this.customerName;
     		 }
    
}
