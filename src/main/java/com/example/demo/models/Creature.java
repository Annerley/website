package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "creatures")
public class Creature {

    @Id
    int id;
    @Column(name = "base_hp")
    int hitPoints;

    //int maxHitPoints = hitPoints;
    String name;

    int movement;
    int baseAttack;
    int range;

    @Transient
    int maxHp = hitPoints;
    @Transient
    int currentInstancesQuantity;

    @Transient
    public int getMaxHp(){
        return maxHp;
    }
    @Transient
    public int getCurrentInstancesQuantity(){
        return currentInstancesQuantity;
    }
    @Transient
    public void SetCurrentInstancesQuantity(int a){
        currentInstancesQuantity = a;
    }



}