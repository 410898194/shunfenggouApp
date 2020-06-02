package com.shunfeng.gou.fanlihuang.entity;

import javax.persistence.*;

@Table(name = "shunfenggou.receivingaddress")
public class Receivingaddress {
    @Id
    private Integer userid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Addresseename")
    private String addresseename;

    @Column(name = "Addresseetelephone")
    private String addresseetelephone;

    private String provincename;

    private String cityname;

    private String countryname;

    private String address;

    private String countrycode;

    private String postalcode;

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Addresseename
     */
    public String getAddresseename() {
        return addresseename;
    }

    /**
     * @param addresseename
     */
    public void setAddresseename(String addresseename) {
        this.addresseename = addresseename;
    }

    /**
     * @return Addresseetelephone
     */
    public String getAddresseetelephone() {
        return addresseetelephone;
    }

    /**
     * @param addresseetelephone
     */
    public void setAddresseetelephone(String addresseetelephone) {
        this.addresseetelephone = addresseetelephone;
    }

    /**
     * @return provincename
     */
    public String getProvincename() {
        return provincename;
    }

    /**
     * @param provincename
     */
    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    /**
     * @return cityname
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * @param cityname
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * @return countryname
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * @param countryname
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return countrycode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * @param countrycode
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * @return postalcode
     */
    public String getPostalcode() {
        return postalcode;
    }

    /**
     * @param postalcode
     */
    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
}