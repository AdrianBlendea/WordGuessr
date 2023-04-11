package Controller;

import Model.DbAttemptPersistance;
import Model.DbUserPersistance;
import Model.Main;
import Model.User;
import View.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;
    public MainController(MainView mainView)
    {
        this.mainView= mainView;
        this.mainView.getWordButton().addActionListener(this.newWord());
        this.mainView.getTryButton().addActionListener(this.tryChallenge());
        this.mainView.getCheckButton().addActionListener(this.tryAnswer());
        this.mainView.getRefreshButton().addActionListener(this.refreshListener());
    }

    public ActionListener newWord()
    {   ActionListener a = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(mainView.getWord().length() > 5 && mainView.getDescriere().length()>0 && mainView.getDescriere().length()<45) {
                if(mainView.getUser().getWords() > 0) {
                    DbUserPersistance.setWord(mainView.getWord(), mainView.getUser().getId(), mainView.getDescriere());
                    DbAttemptPersistance.removeallAtempts(mainView.getUser().getId());
                    DbUserPersistance.updateWordsCount(mainView.getUser().getId(),-1);
                    mainView.getUser().setFoundWord(false);
                    mainView.refreshFoundWord();

                }
                else
                    JOptionPane.showMessageDialog(null,"Nu poti propune un cuvant nou cat timp nu ai niciun cuvant");
            }
            else
                JOptionPane.showMessageDialog(null,"Cuvantul ales nu poate fi mai scurt de 6 litere iar descrierea nu poate fi mai lunga de 45 de litere");


        }
    };
       return a;
    }
    public ActionListener tryChallenge()
    {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.refreshFoundWord();
                String name = mainView.getLeaderBoardTable().getValueAt(mainView.getLeaderBoardTable().getSelectedRow(),0).toString();
                User u = DbUserPersistance.findByUsername(name);
                if(!name.equals(mainView.getUser().getUsername()) && !u.isFoundWord()) {

                    mainView.setDescrierePane(u.getDescriere());
                    mainView.getCheckButton().setEnabled(true);

                }
                else if(u.isFoundWord())
                {
                    JOptionPane.showMessageDialog(null,"Cineva deja a completat provocarea");
                    mainView.setDescrierePane("");
                    mainView.getCheckButton().setEnabled(false);

                }
                else
                {   mainView.setDescrierePane("");
                    JOptionPane.showMessageDialog(null,"Nu iti poti selecta propria provocare");
                    mainView.getCheckButton().setEnabled(false);

                }
            }
        };

        return a;
    }
    public ActionListener tryAnswer()
    {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String answer = mainView.getTryText();
                if(answer.length()<=5)
                    JOptionPane.showMessageDialog(null,"Cuvant prea scurt");

                else
                {
                    String name = mainView.getLeaderBoardTable().getValueAt(mainView.getLeaderBoardTable().getSelectedRow(),0).toString();
                    User u = DbUserPersistance.findByUsername(name);
                    DbAttemptPersistance.addAttempt(u.getId(),mainView.getUser().getId());
                    String corectanswer = DbUserPersistance.findWord(u.getId());
                    if(corectanswer.equals(answer))
                    {    JOptionPane.showMessageDialog(null,"Raspuns corect");
                        DbUserPersistance.setFound(u.getId());
                        DbUserPersistance.updateWordsCount(mainView.getUser().getId(),1);
                        int tries = DbAttemptPersistance.countTries(u.getId(),mainView.getUser().getId());
                        if(tries == 1)
                        {
                            DbUserPersistance.updateFirstTryBadges(mainView.getUser().getId(),1);
                            JOptionPane.showMessageDialog(null,"Prima incercare, Badge primit");
                        }
                        DbAttemptPersistance.removeallAtempts(u.getId());
                        mainView.getCheckButton().setEnabled(false);
                        mainView.refresh();

                    }
                    else
                    {   JOptionPane.showMessageDialog(null,"Raspuns gresit");
                        int fails = DbAttemptPersistance.countPeoples(u.getId());
                        if(fails % 10 == 0 ){
                            DbUserPersistance.updateInARowBadges(u.getId(), 1);
                           }
                        mainView.refresh();
                        System.out.println(fails);
                    }

                }

            }
        };
        return a;
    }
    public ActionListener refreshListener()
    {
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.refresh();
                mainView.refreshFoundWord();
            }
        };
        return a;
    }

}
