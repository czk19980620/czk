package com.pojo;


import java.math.BigDecimal;
import java.util.Objects;

public class TBook {

  private String bid;
  private String bname;
  private String author;
  private BigDecimal price;
  private BigDecimal currPrice;
  private BigDecimal discount;
  private String press;
  private String publishtime;
  private long edition;
  private long pageNum;
  private long wordNum;
  private String printtime;
  private long booksize;
  private String paper;
  private String cid;
  private String image_w;
  private String image_b;
  private long orderBy;

  public String getBid() {
    return bid;
  }

  public void setBid(String bid) {
    this.bid = bid;
  }

  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getCurrPrice() {
    return currPrice;
  }

  public void setCurrPrice(BigDecimal currPrice) {
    this.currPrice = currPrice;
  }

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getPublishtime() {
    return publishtime;
  }

  public void setPublishtime(String publishtime) {
    this.publishtime = publishtime;
  }

  public long getEdition() {
    return edition;
  }

  public void setEdition(long edition) {
    this.edition = edition;
  }

  public long getPageNum() {
    return pageNum;
  }

  public void setPageNum(long pageNum) {
    this.pageNum = pageNum;
  }

  public long getWordNum() {
    return wordNum;
  }

  public void setWordNum(long wordNum) {
    this.wordNum = wordNum;
  }

  public String getPrinttime() {
    return printtime;
  }

  public void setPrinttime(String printtime) {
    this.printtime = printtime;
  }

  public long getBooksize() {
    return booksize;
  }

  public void setBooksize(long booksize) {
    this.booksize = booksize;
  }

  public String getPaper() {
    return paper;
  }

  public void setPaper(String paper) {
    this.paper = paper;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public String getImage_w() {
    return image_w;
  }

  public void setImage_w(String image_w) {
    this.image_w = image_w;
  }

  public String getImage_b() {
    return image_b;
  }

  public void setImage_b(String image_b) {
    this.image_b = image_b;
  }

  public long getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(long orderBy) {
    this.orderBy = orderBy;
  }

  @Override
  public String toString() {
    return "TBook{" +
            "bid='" + bid + '\'' +
            ", bname='" + bname + '\'' +
            ", author='" + author + '\'' +
            ", price=" + price +
            ", currPrice=" + currPrice +
            ", discount=" + discount +
            ", press='" + press + '\'' +
            ", publishtime='" + publishtime + '\'' +
            ", edition=" + edition +
            ", pageNum=" + pageNum +
            ", wordNum=" + wordNum +
            ", printtime='" + printtime + '\'' +
            ", booksize=" + booksize +
            ", paper='" + paper + '\'' +
            ", cid='" + cid + '\'' +
            ", image_w='" + image_w + '\'' +
            ", image_b='" + image_b + '\'' +
            ", orderBy=" + orderBy +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TBook tBook = (TBook) o;
    return Objects.equals(bid, tBook.bid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bid);
  }
}
