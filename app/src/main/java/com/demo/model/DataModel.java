package com.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vijayaraj_s on 18/07/18.
 */

public class DataModel implements Serializable {

    private static final long serialVersionUID = -3828814959960134587L;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("rows")
    @Expose
    private List<Row> rows = null;

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return set title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return items list
     */
    public List<Row> getRows() {
        return rows;
    }

    /**
     * @return set items list
     */
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "title='" + title + '\'' +
                ", rows=" + rows +
                '}';
    }
}
