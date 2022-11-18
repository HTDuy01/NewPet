/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author 01
 */
public class Pet {
    private String id;
    private String name ;
    private String ownerName ;
    private String serviceName ;
    private String note ;
    private String cage;

    public Pet() {
    }

    public Pet(String id, String name, String ownerName, String serviceName, String note, String cage) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.serviceName = serviceName;
        this.note = note;
        this.cage = cage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }
    
    
}
