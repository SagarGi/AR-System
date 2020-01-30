package com.gces.minor_project_i;

/**
 *
 * @author pravinewa
 */


public class User {
    
    private String vehiclenumber, companyname, ownername, vehicletype, municipality, registrationdate;

    public User(String vehiclenumber, String ownername, String companyname, String vehicletype, String municipality, String registrationdate)
    {
        this.vehiclenumber = vehiclenumber;
        this.ownername = ownername;
        this.companyname = companyname;
        this.vehicletype = vehicletype;
        this.municipality = municipality;
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
    public String getmunicipality()
    {
        return municipality;
    }
    public String getregistrationdate()
    {
        return registrationdate;
    }    
}
