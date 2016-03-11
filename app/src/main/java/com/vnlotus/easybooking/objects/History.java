package com.vnlotus.easybooking.objects;

import java.util.Date;

public class History {
  private String storeName;
  private int total;
  private Date date;
  private boolean isPaid;

  public History(String storeName, int total, Date date, boolean isPaid) {
    this.storeName = storeName;
    this.total = total;
    this.date = date;
    this.isPaid = isPaid;
  }

  public History() {
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public boolean isPaid() {
    return isPaid;
  }

  public void setIsPaid(boolean isPaid) {
    this.isPaid = isPaid;
  }
}
