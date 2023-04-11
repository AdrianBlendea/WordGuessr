package Controller;

import Model.DbUserPersistance;
import Model.User;
import View.LoginView;
import View.MainView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView)
    {
        this.loginView = loginView;
        this.loginView.show();

        loginView.getLoginButton().addActionListener(this.login());
    }
    public ActionListener login ()
    {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                User found = DbUserPersistance.checkUser(username,password);
                if(found != null)
                {
                    MainView mainView = new MainView(found);
                    MainController mainController = new MainController(mainView);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Utilizator inexistent");
                }
            }
        };
        return a;
    }


}




