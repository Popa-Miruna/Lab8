import java.sql.*;

public class JDBC {
    public static void main (String[] args) {

        DataBase db = DataBase.getInstance();
        db.createTables();
        Connection con = db.getCon();
        ArtistController art = new ArtistController(con);
        art.create("Alexandru", "Iasi");
        art.findByName("Marian");
        art.findByName("Andrei");

        AlbumController alb = new AlbumController(con);
        alb.create("Radu", 4, 2000);
        alb.findByArtist(4);
        alb.findByArtist(5);
        db.closeConnection();
    }
}
