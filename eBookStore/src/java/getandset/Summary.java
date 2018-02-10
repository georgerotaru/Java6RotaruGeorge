/*
 * Document : AdminUserRoles.java
 * Author : George
 * Copyright : George
 */
package getandset;

import java.text.DecimalFormat;

/**
 * This class implements getters and setter to use in the inventory web page.
 * 
 * @author George
 */
public class Summary {
   private Integer ebookCount;
   private Integer userCount;
   private Double moneyCount;
   private String ebookIsbn;
   private String ebookTitle;
   private Double ebookSum;

    public Integer getEbookCount() {
        return ebookCount;
    }

    public void setEbookCount(Integer ebookCount) {
        this.ebookCount = ebookCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Double getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(Double moneyCount) {
        this.moneyCount = moneyCount;
    }

    public String getEbookIsbn() {
        return ebookIsbn;
    }

    public void setEbookIsbn(String ebookIsbn) {
        this.ebookIsbn = ebookIsbn;
    }

    public String getEbookTitle() {
        return ebookTitle;
    }

    public void setEbookTitle(String ebookTitle) {
        this.ebookTitle = ebookTitle;
    }

    public Double getEbookSum() {
        //return value in a 2 decimal format
        DecimalFormat df = new DecimalFormat("##.##");
        String formatted = df.format(ebookSum);
        return Double.parseDouble(formatted);
    }

    public void setEbookSum(Double ebookSum) {
        this.ebookSum = ebookSum;
    }
   
}
