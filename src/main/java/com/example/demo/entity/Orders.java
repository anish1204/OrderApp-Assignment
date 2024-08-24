package com.example.demo.entity;


import jakarta.persistence.*;


@Entity(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;


    @Column(name = "company_name")
    public String company_name;

    @Column(name = "website")
    public String website;

    @Column(name = "location")
    public String location;

    @Column(name = "nature_of_business")
    public String nature_of_business;

    @Column(name = "manufacturing_processes")
    public String manufacturing_processes;

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNature_of_business() {
        return nature_of_business;
    }

    public void setNature_of_business(String nature_of_business) {
        this.nature_of_business = nature_of_business;
    }

    public String getManufacturing_processes() {
        return manufacturing_processes;
    }

    public void setManufacturing_processes(String manufacturing_processes) {
        this.manufacturing_processes = manufacturing_processes;
    }

    public Orders(int supplier_id,String company_name, String website, String location, String nature_of_business, String manufacturing_processes) {
        this.supplier_id = supplier_id;
        this.company_name = company_name;
        this.website = website;
        this.location = location;
        this.nature_of_business = nature_of_business;
        this.manufacturing_processes = manufacturing_processes;
    }

    public Orders()
    {

    }

}
