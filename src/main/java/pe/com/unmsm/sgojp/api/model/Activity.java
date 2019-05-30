package pe.com.unmsm.sgojp.api.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
//@XmlRootElement(name = "Activity")
public class Activity {

    private int id;
    private String name;
    private float description;

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

    public float getDescription() {
        return description;
    }

    public void setDescription(float description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

}
