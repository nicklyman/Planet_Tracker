import org.sql2o.*;
import java.util.List;

public class User{
  private String email;
  private String telephone;
  private String telephone_carrier;
  private String password;
  private String user_name;
  private double latitude;
  private double longitude;
  private String user_time;
  private boolean subscription;
  private int id;

  public User(String email, String telephone, String telephone_carrier, String user_name, String password){
    this.email = email;
    this.telephone = telephone;
    this.telephone_carrier = telephone_carrier;
    this.password = password;
    this.user_name = user_name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone(){
    return telephone;
  }

  public String getPassword() {
    return password;
  }

  public String getUserName() {
    return user_name;
  }

  public String getTelephoneCarrier() {
    return telephone_carrier;
  }

  public int getId() {
    return id;
  }

  public boolean getSubscription() {
    return subscription;
  }

  public void setSubscription(boolean subscription) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "ALTER TABLE users SET subscription = :subscription WHERE id=:id";
      con.createQuery(sql).addParameter("subscription", subscription).addParameter("id", this.getId()).executeUpdate();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO users (email, telephone, telephone_carrier, user_name, password, subscription) VALUES (:email, :telephone, :telephone_carrier, :user_name, :password, :subscription)";
      this.id = (int) con.createQuery(sql, true).addParameter("email", this.email).addParameter("telephone", this.telephone).addParameter("telephone_carrier", this.telephone_carrier).addParameter("user_name", this.user_name).addParameter("password", this.password).addParameter("subscription", this.subscription).executeUpdate().getKey();
    }
  }

  public static User find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE id=:id";
      return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(User.class);
    }
  }

  public static List<User> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users";
      return con.createQuery(sql).executeAndFetch(User.class);
    }
  }

  public static int noCopiesInData(User checkUser){
    int copyFinder = 0;
    for(User user : User.all()){
      if (user.equals(checkUser)){
        copyFinder = user.getId();
      }
    }
    return copyFinder;
  }

  public static User userNamePasswordLookUp(String username, String password) {
    int userLookUpID = 0;
    for(User user : User.all()) {
      if(user.getUserName().equals(username) && user.getPassword().equals(password)){
        userLookUpID = user.getId();
      }
    }
    return User.find(userLookUpID);
  }

  public void setTime(String month, String day, String year, String time) {
    String userTime = year + "-" + month + "-" + day + " " + time;
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE users SET user_time = :userTime WHERE id=:id";
      con.createQuery(sql).addParameter("userTime", userTime).addParameter("id", this.id).executeUpdate();
    }
  }

  public String getUserTime() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT user_time FROM users WHERE id = :id";
      return con.createQuery(sql).addParameter("id", this.id).executeAndFetchFirst(String.class);
    }
  }

  public boolean delete(String password) {
    User user = User.find(this.getId());
    if(user.getPassword().equals(password)){
      try(Connection con = DB.sql2o.open()) {
        String sql = "DELETE FROM users WHERE id = :id";
        con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
      }
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean equals(Object object) {
    if(!(object instanceof User)){
      return false;
    } else {
      User user = (User) object;
      return this.getEmail().equals(user.getEmail()) && this.getPhone().equals(user.getPhone()) && this.getPassword().equals(user.getPassword()) && this.getUserName().equals(user.getUserName()) && this.getTelephoneCarrier().equals(user.getTelephoneCarrier());
    }
  }


}
