package com.vnlotus.easybooking.objects;

public class Product {

  private String thumbUrl;
  private String name;
  private int price;

  public String getThumbUrl() {
    return thumbUrl;
  }

  public void setThumbUrl(String thumbUrl) {
    this.thumbUrl = thumbUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Product(String thumbUrl, String name, int price) {
    this.thumbUrl = thumbUrl;
    this.name = name;
    this.price = price;
  }

  public Product() {
  }
}
