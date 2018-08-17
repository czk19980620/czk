package com.jdbc;


public class Book1 {

  private String id;
  private String name;
  private String aothor;


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


  public String getAothor() {
    return aothor;
  }

  public void setAothor(String aothor) {
    this.aothor = aothor;
  }

  @Override
  public String toString() {
    return "Book1{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", aothor='" + aothor + '\'' +
            '}';
  }
}
