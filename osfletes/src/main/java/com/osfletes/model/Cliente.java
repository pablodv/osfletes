package com.osfletes.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="CLIENTE")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Cliente {

}
