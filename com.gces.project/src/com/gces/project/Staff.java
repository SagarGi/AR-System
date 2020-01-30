package com.gces.project;


import java.security.*;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author pravinewa
 */
class Staff {
    private String staffid1;
    private String contactno1;
    private String username1,address1,gender1,shift1;
    private String hashpass;
    public Staff(String  a,String b,String c, String d,String e,String f)
    {
        staffid1=a;
        username1=b;
        contactno1=d;
        address1=c;
        gender1=e;
        shift1=f;
    }

    Staff() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getstaffid1()
    {
        return staffid1;
    }
     public String getusername1()
    {
        return username1;
    } 
     public String getcontactno1()
    {
        return contactno1;
    }
     public String getaddress1()
    {
        return address1;
    }
      public String getgender1()
    {
        return gender1;
    }
      public String getshift1()
    {
        return shift1;
    }
      
      
       
    
}
