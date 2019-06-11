module Javafx{
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.swt;
    requires javafx.web;
    requires com.jfoenix;
    opens sample;
    opens controller;
    opens controllerAdmin;
    opens JDBC;
}