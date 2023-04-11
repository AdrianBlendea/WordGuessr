package View;

import Model.DbUserPersistance;
import Model.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class MainView extends JFrame {

    private JPanel contentPane;
    private JTable leaderBoardTable;
    private JLabel yourTotalLabel;
    private JLabel streakLabel;
    private JLabel firstTryLabel;
    private JLabel foundLabel;
    private JLabel stats4;
    private JLabel stats3;
    private JLabel stats2;
    private JLabel stats1;
    private JLabel statsLabel;
    private JLabel welcomeLabel;
    JButton tryButton;
    JTextField wordText;
    JScrollPane scrollPane;
    JButton wordButton;
    JLabel notFoundLabel;
    JTextPane descrierePane;
    JTextPane descrierePaneAfisare;
    JTextField guessText;
    private User user;
    JButton checkButton;
    JButton refreshButton;
    public MainView(User usr) {

        this.user = usr;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 870, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        this.show();


        JLabel leaderboardLabel = new JLabel("");
        leaderboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        leaderboardLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        leaderboardLabel.setIcon(new ImageIcon("Images\\leader.png"));
        leaderboardLabel.setForeground(Color.BLACK);
        leaderboardLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        leaderboardLabel.setBounds(196, 10, 252, 213);
        contentPane.add(leaderboardLabel);

        leaderBoardTable = new JTable();
        String[] cols = {
                "Name", "Words", "First try", "3 in a row", "Total points"
        };
        DefaultTableModel model = new DefaultTableModel(cols,0);
        ArrayList<User> top = DbUserPersistance.findAll();
        for(User u:top)
        {
            String user = u.getUsername();
            int data1 =u.getWords();
            int data2=u.getFirsttryBadges();
            int data3 = u.getInARowBadges();
            int data4 = u.getTotal();
            Object[] row = {user,data1,data2,data3,data4};
            model.addRow(row);

        }
        leaderBoardTable.setModel(model);

        leaderBoardTable.getColumnModel().getColumn(1).setPreferredWidth(115);
        leaderBoardTable.getColumnModel().getColumn(2).setPreferredWidth(107);
        leaderBoardTable.getColumnModel().getColumn(3).setPreferredWidth(65);
        leaderBoardTable.getColumnModel().getColumn(4).setPreferredWidth(79);
        leaderBoardTable.getColumnModel().getColumn(4).setMinWidth(24);
       // leaderBoardTable.setBounds(22, 272, 560, 231);
        scrollPane = new JScrollPane(leaderBoardTable);
        scrollPane.setBounds(22, 272, 560, 231);
        //scrollPane.getViewport().add(leaderBoardTable);
        contentPane.add(scrollPane);

        JLabel starLabel = new JLabel("");
        starLabel.setIcon(new ImageIcon("Images\\star.png"));
        starLabel.setBounds(300, 219, 45, 43);
        contentPane.add(starLabel);

        JLabel userLabel = new JLabel("");
        userLabel.setIcon(new ImageIcon("Images\\user.png"));
        userLabel.setBounds(50, 219, 45, 43);
        contentPane.add(userLabel);

        JLabel wordsLabel = new JLabel("");
        wordsLabel.setIcon(new ImageIcon("Images\\checked.png"));
        wordsLabel.setBounds(174, 219, 45, 43);
        contentPane.add(wordsLabel);

        JLabel fireLabel = new JLabel("");
        fireLabel.setIcon(new ImageIcon("Images\\fire.png"));
        fireLabel.setBounds(407, 219, 45, 53);
        contentPane.add(fireLabel);

        JLabel totalLabel = new JLabel("");
        totalLabel.setIcon(new ImageIcon("Images\\sigma.png"));
        totalLabel.setBounds(514, 219, 45, 43);
        contentPane.add(totalLabel);

        welcomeLabel = new JLabel("Welcome,"+usr.getUsername());
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        welcomeLabel.setBounds(0, 45, 151, 23);
        contentPane.add(welcomeLabel);

        statsLabel = new JLabel("Your stats:");
        statsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        statsLabel.setBounds(449, 45, 151, 23);
        contentPane.add(statsLabel);

        stats1 = new JLabel("");
        stats1.setIcon(new ImageIcon("Images\\checked.png"));
        stats1.setBounds(444, 66, 45, 43);
        contentPane.add(stats1);

        stats2 = new JLabel("");
        stats2.setIcon(new ImageIcon("Images\\star.png"));
        stats2.setBounds(496, 66, 45, 43);
        contentPane.add(stats2);

        stats3 = new JLabel("");
        stats3.setIcon(new ImageIcon("Images\\fire.png"));
        stats3.setBounds(537, 66, 45, 43);
        contentPane.add(stats3);

        stats4 = new JLabel("");
        stats4.setIcon(new ImageIcon("Images\\sigma.png"));
        stats4.setBounds(576, 66, 45, 43);
        contentPane.add(stats4);

        foundLabel = new JLabel(String.valueOf(usr.getWords()));
        foundLabel.setBounds(433, 108, 45, 13);
        contentPane.add(foundLabel);

        firstTryLabel = new JLabel(String.valueOf(usr.getFirsttryBadges()));
        firstTryLabel.setBounds(488, 108, 45, 13);
        contentPane.add(firstTryLabel);

        streakLabel = new JLabel(String.valueOf(usr.getInARowBadges()));
        streakLabel.setBounds(537, 108, 45, 13);
        contentPane.add(streakLabel);

        yourTotalLabel = new JLabel(String.valueOf((usr.getTotal())));
        yourTotalLabel.setBounds(576, 108, 45, 13);
        contentPane.add(yourTotalLabel);

        wordText = new JTextField();
        wordText.setEditable(usr.isFoundWord());
        wordText.setBounds(22, 102, 96, 19);
        contentPane.add(wordText);
        wordText.setColumns(10);

         wordButton = new JButton("Propune cuvant");
        wordButton.setBounds(134, 101, 124, 21);
        contentPane.add(wordButton);
        wordButton.setEnabled(usr.isFoundWord());


         notFoundLabel = new JLabel("Cuvantul tau nu a fost gasit inca");
        notFoundLabel.setBounds(0, 131, 150, 50);
        notFoundLabel.setVisible(!usr.isFoundWord());
        contentPane.add(notFoundLabel);

        tryButton = new JButton("Incearca provocarea");
        tryButton.setBounds(632, 233, 174, 21);
        contentPane.add(tryButton);

        guessText = new JTextField();
        guessText.setBounds(632, 309, 174, 19);
        contentPane.add(guessText);

        JLabel descriereLabel = new JLabel("l");
        descriereLabel.setBounds(632, 354, 187, 87);
        contentPane.add(descriereLabel);

        descrierePane = new JTextPane();
        descrierePane.setBounds(134, 45, 124, 46);
        descrierePane.setEditable(usr.isFoundWord());
        contentPane.add(descrierePane);

       descrierePaneAfisare = new JTextPane();
        descrierePaneAfisare.setBounds(657, 357, 124, 46);
        descrierePaneAfisare.setEditable(false);
        contentPane.add(descrierePaneAfisare);

        checkButton = new JButton("Verifica");
        checkButton.setBounds(678, 426, 85, 21);
        checkButton.setEnabled(false);
        contentPane.add(checkButton);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(636, 22, 85, 21);
        contentPane.add(refreshButton);


    }

    public void closeWordSubmission()
    {
        wordButton.setEnabled(false);
        notFoundLabel.setVisible(true);
        wordText.setEditable(false);
        wordText.setText("");
        descrierePane.setEditable(false);
        descrierePane.setText("");


    }
    public void openWordSubmission()
    {
        wordButton.setEnabled(true);
        notFoundLabel.setVisible(false);
        wordText.setEditable(true);
        wordText.setText("");
        descrierePane.setEditable(true);
        descrierePane.setText("");
    }
    public void refreshFoundWord()
    {
        User u = DbUserPersistance.findByUsername(user.getUsername());

        if(u.isFoundWord())
        {
            openWordSubmission();
        }
        else
        {
            closeWordSubmission();
        }
    }
    public void refresh()
    {   User u = DbUserPersistance.findByUsername(user.getUsername());
        this.descrierePaneAfisare.setText("");

        String[] cols = {
                "Name", "Words", "First try", "3 in a row", "Total points"
        };
        DefaultTableModel model = new DefaultTableModel(cols,0);
        ArrayList<User> top = DbUserPersistance.findAll();
        for(User us:top)
        {
            String user = us.getUsername();
            int data1 =us.getWords();
            int data2=us.getFirsttryBadges();
            int data3 = us.getInARowBadges();
            int data4 = us.getTotal();
            Object[] row = {user,data1,data2,data3,data4};
            model.addRow(row);

        }
        leaderBoardTable.setModel(model);


        foundLabel.setText(String.valueOf(u.getWords()));


        firstTryLabel.setText(String.valueOf(u.getFirsttryBadges()));


        streakLabel.setText(String.valueOf(u.getInARowBadges()));

        yourTotalLabel.setText(String.valueOf((u.getTotal())));




    }


    public JButton getWordButton() {
        return wordButton;
    }
    public String getWord()
    {
        return this.wordText.getText();
    }

    public User getUser() {
        return user;
    }
    public String getDescriere()
    {
        return this.descrierePane.getText();
    }

    public JButton getTryButton() {
        return tryButton;
    }

    public JTable getLeaderBoardTable() {
        return leaderBoardTable;
    }
    public void setDescrierePane(String descriere)
    {
        this.descrierePaneAfisare.setText(descriere);
    }
    public JButton getCheckButton ()
    {
        return this.checkButton;
    }
    public String getTryText()
    {
        return this.guessText.getText();
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }
}
