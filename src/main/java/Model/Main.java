package Model;

import Controller.LoginController;
import Model.ConnectionFactory;
import Model.DbUserPersistance;
import View.LoginView;
import View.MainView;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);






    }
}
