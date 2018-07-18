package com.demo.listeners;

import com.demo.model.Row;

import java.util.List;


/**
 * Created by vijayaraj_s on 18/07/18.
 */

public interface ApiCallback {

    void notifySuccess(List<Row> _data);

    void notifyError();

}
