import org.sql2o.*;

public class User{
  private String name;
  private String email;
  private String telephone;
  private double latitude;
  private double longitude;
  private String user_time;
  private int id;

  public User(String name, String email, String telephone){
    this.name = name;
    this.email = email;
    this.telephone = telephone;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users (name, email, telephone) VALUES (:name, :email, :telephone)";
      this.id = (int) con.createQuery(sql, true).addParameter("name", this.name).addParameter("email", this.email).addParameter("telephone", this.telephone).executeUpdate().getKey();
    }
  }

  public static List<User> all() {
    try(Connection con = DB.sql20.open()) {
      String sql = "SELECT * FROM users";
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  public String getUserTime() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT user_time FROM users WHERE id = :id";
      return con.createQuery(sql).addParameter("id", this.id).executeAndFetchFirst(String.class);
    }
  }

  public void setTime(String month, String day, String year, String time) {
    String userTime = year + "-" + month + "-" + day + " " + time;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET user_time = :userTime WHERE id=:id";
      con.createQuery(sql).addParameter("userTime", userTime).addParameter("id", this.id).executeUpdate();
    }
  }


}
