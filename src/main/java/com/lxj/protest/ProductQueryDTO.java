package com.lxj.protest;

import java.io.Serializable;

/**
 * Created by lixuejiao on 16/9/7.
 */
public class ProductQueryDTO implements Serializable{
    private int status;
    private int stock;
    private int[] pids;
    private int[] cids;
    private int[] bids;
    private int[] vids;
    private int offset;
    private int limit;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int[] getPids() {
        return pids;
    }

    public void setPids(int[] pids) {
        this.pids = pids;
    }

    public int[] getCids() {
        return cids;
    }

    public void setCids(int[] cids) {
        this.cids = cids;
    }

    public int[] getBids() {
        return bids;
    }

    public void setBids(int[] bids) {
        this.bids = bids;
    }

    public int[] getVids() {
        return vids;
    }

    public void setVids(int[] vids) {
        this.vids = vids;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
