package com.example.mysql;

public class Model {
    String id,epf,name,email,password;

    public Model(String id ,String epf, String name, String email, String password ) {
        this.id = id;
        this.epf = epf;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId(){
        return id;
    }
    public String getEpf(){
        return epf;
    }
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

}
