package Model;

public class User implements  Comparable<User> {
    private int id;
    private String username;
    private int words;
    private int firsttryBadges;
    private int inARowBadges;
    private boolean foundWord ;
    private String descriere;
    private int total;

    public User(int id,String username, int words, int firsttryBadges, int inARowBadges,int found,String desc) {
        this.id = id;
        this.username = username;
        this.words = words;
        this.firsttryBadges = firsttryBadges;
        this.inARowBadges = inARowBadges;
        this.descriere = desc;
        if(found == 0)
            this.foundWord = false;

        else
            this.foundWord = true;

        this.total = this.words + this.firsttryBadges*5 + this.inARowBadges*3;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", words=" + words +
                ", firsttryBadges=" + firsttryBadges +
                ", inARowBadges=" + inARowBadges +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public int getWords() {
        return words;
    }

    public int getFirsttryBadges() {
        return firsttryBadges;
    }

    public int getInARowBadges() {
        return inARowBadges;
    }

    public boolean isFoundWord() {
        return foundWord;
    }

    public int getId() {
        return id;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setFoundWord(boolean foundWord) {
        this.foundWord = foundWord;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public int compareTo(User o) {
        return o.getTotal()-this.total;
    }
}
