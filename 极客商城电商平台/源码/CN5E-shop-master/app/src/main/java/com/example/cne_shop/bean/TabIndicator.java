package com.example.cne_shop.bean;



public class TabIndicator {

    private int tabTitle ;
    private int tabPhoto ;
    private Class<?> fragment ;

    public TabIndicator(int tabTitle , int tabPhoto ,Class<?> fragment ){
        this.fragment = fragment ;
        this.tabPhoto = tabPhoto ;
        this.tabTitle = tabTitle ;
    }
    public int getTabTitle() {
        return tabTitle;
    }

    public int getTabPhoto() {
        return tabPhoto;
    }

    public  Class<?>  getFragment() {
        return fragment;
    }

}
