package com.example.tp_api_rest_avec_retrofit.model;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public int getId() {return id;}
    public String getName() {return name;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public Address getAddress() {return address;}
    public String getPhone() {return phone;}
    public String getWebsite() {return website;}
    public Company getCompany() {return company;}

    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public String getBs() {
            return bs;
        }
    }
}