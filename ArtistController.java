import java.sql.*;

public class ArtistController {
    private static Connection con;

    public ArtistController(Connection con) {
        this.con = con;
    }

    public void create(String name, String country) {
        try{
            Statement st = con.createStatement();
            String sql = "INSERT INTO artists (name, country) VALUES ('" + name + "', '" + country + "')";
            st.executeUpdate(sql);
            System.out.println(name + " from " + country + " was inserted to the table artists!");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void findByName(String name) {
        try{
            Statement st = con.createStatement();
            String sql = "SELECT * FROM artists WHERE name = '" + name + "'";
            ResultSet r = st.executeQuery(sql);
            int id = 0;
            while(r.next()) {
                id = r.getInt("id");
                String result_name = r.getString("name");
                String country = r.getString("country");
                System.out.println(id + " * " + result_name + " * " + country);
            }
            if (id == 0) {
                System.out.println("Name " + name + " was not found!");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
