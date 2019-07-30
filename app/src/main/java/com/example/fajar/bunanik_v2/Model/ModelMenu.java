package com.example.fajar.bunanik_v2.Model;

import java.util.List;

/**
 * Created by Fajar on 17/12/2017.
 */

public class ModelMenu {

    String type;
    List<MMenus.Menus> listMenus;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MMenus.Menus> getListMenus() {
        return listMenus;
    }

    public void setListMenus(List<MMenus.Menus> listMenus) {
        this.listMenus = listMenus;
    }
}
