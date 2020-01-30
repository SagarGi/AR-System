package com.gces.project;

/**
 *
 * @author pravinewa
 */


public class User {
    
    private String vehiclenumber, companyname, ownername, vehicletype, address, registrationdate;

    public User(String vehiclenumber, String ownername, String companyname, String vehicletype, String address, String registrationdate)
    {
        this.vehiclenumber = vehiclenumber;
        this.ownername = ownername;
        this.companyname = companyname;
        this.vehicletype = vehicletype;
        this.address = address;
        this.registrationdate = registrationdate;
    }
    public String getvehiclenumber()
    {
        return vehiclenumber;
    }
    public String getownername()
    {
        return ownername;
    }
    public String getcompanyname()
    {
        return companyname;
    }
    public String getvehicletype()
    {
        return vehicletype;
    }
    public String getaddress()
    {
        return address;
    }
    public String getregistrationdate()
    {
        return registrationdate;
    }    
}
