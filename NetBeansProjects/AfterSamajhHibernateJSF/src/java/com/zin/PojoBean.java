/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zin;

import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@ManagedBean
public class PojoBean {
    
    private int id;
    private String name;

    public PojoBean() {
    }
    private String city;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void add()
    {
        PojoBean p = new PojoBean();
        p.setId(id);
        p.setAge(age);
        p.setCity(city);
        p.setName(name);
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        
        s.saveOrUpdate(p);
        t.commit();
        System.out.println("Record Inserted");
    }
    
}
