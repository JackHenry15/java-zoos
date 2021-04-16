package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "zooanimals")
@IdClass(ZooAnimalsId.class)
public class ZooAnimals extends Auditable implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "animals", allowSetters = true)
    private Animal animal;

    @Id
    @ManyToOne
    @JoinColumn(name = "animalid")
    @JsonIgnoreProperties(value = "zoos", allowSetters = true)
    private Zoo zoo;


    private String incomingzoo;

    public ZooAnimals() {
    }

    public ZooAnimals(Animal animal, Zoo zoo, String incomingzoo) {
        this.animal = animal;
        this.zoo = zoo;
        this.incomingzoo = incomingzoo;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public String getIncomingzoo() {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo) {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if(!(o instanceof ZooAnimals))
        {
            return false;
        }
        ZooAnimals that = (ZooAnimals) o;
        return ((zoo == null) ? 0 : zoo.getZooid()) == ((that.zoo == null) ? 0 : that.zoo.getZooid()) &&
                ((animal == null) ? 0 : animal.getAnimalid()) == ((that.animal == null) ? 0 : that.animal.getAnimalid());
    }

    @Override
    public int hashCode() {
        return 55;
    }


}
