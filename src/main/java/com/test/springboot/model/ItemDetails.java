package com.test.springboot.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class ItemDetails  implements Serializable {

        
    public ItemDetails(){
    }
	@Id
	@Column(name = "itemDetailsId")
    private Integer itemDetailsId;
        
  	@Column(name = "itemId")
    private String itemId;
        
  	@Column(name = "itemPropertyDesc")
    private String itemPropertyDesc;
        
  	@Column(name = "itemProperty")
    private String itemProperty;
        
  	@Column(name = "ItemDetailsName")
    private String ItemDetailsName;
        
       	public void setItemDetailsId ( Integer itemDetailsId ){
       		 this.itemDetailsId = itemDetailsId;
    }
   
       	public Integer getItemDetailsId ( ){
       		 return this.itemDetailsId;
     		 }
    
            	public void setItemId ( String itemId ){
       		 this.itemId=itemId;
      		 }
        	public void setItemPropertyDesc ( String itemPropertyDesc ){
       		 this.itemPropertyDesc=itemPropertyDesc;
      		 }
        	public void setItemProperty ( String itemProperty ){
       		 this.itemProperty=itemProperty;
      		 }
        	public void setItemDetailsName ( String ItemDetailsName ){
       		 this.ItemDetailsName=ItemDetailsName;
      		 }
       
          	public String getItemId ( ){
       		 return this.itemId;
     		 }
        	public String getItemPropertyDesc ( ){
       		 return this.itemPropertyDesc;
     		 }
        	public String getItemProperty ( ){
       		 return this.itemProperty;
     		 }
        	public String getItemDetailsName ( ){
       		 return this.ItemDetailsName;
     		 }
    
}
