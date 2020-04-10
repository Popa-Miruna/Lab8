import java.sql.*;

public class AlbumController {
    private static Connection con;


    public AlbumController(Connection con) {
        this.con = con;
    }

    public void create(String name, int artistId, int releaseYear) {
        try{
            Statement st = con.createStatement();
            String sql = "INSERT INTO albums (name, artist_id, release_year) VALUES ('" + name + "', '" + artistId + "', '" +
                    releaseYear + "')";
            st.executeUpdate(sql);
            System.out.println(name + " * " + artistId + " * " + releaseYear + " * was inserted to the table albums!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void findByArtist(int artistId) {
        try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM albums WHERE artist_id = " + artistId;
            ResultSet r = st.executeQuery(sql);
            int id = 0;
            while(r.next()) {
                id = r.getInt("id");
                String result_name = r.getString("name");
                int art_id = r.getInt("artist_id");
                int rel_year = r.getInt("release_year");
                System.out.println(id + " * " + result_name + " * " + art_id + " * " + rel_year);
            }
            if (id == 0) {
                System.out.println("Artist id '" + artistId + "' was not found!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
