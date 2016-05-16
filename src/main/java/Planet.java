import org.sql2o.*;


public class Planet {
    private String planet_name;
    private String date_time;
    private double azimuth;
    private double elevation;
    private int id;

  public Planet(String name){
    this.planet_name = name;
  }

  public String getName(){
    return planet_name;
  }

  public String getPlanetTime() {
    return date_time;
  }

  public Planet find(User user){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM " + this.getName() + " WHERE date_time = :user_time";
      return con.createQuery(sql).addParameter("user_time", user.getUserTime()).executeAndFetchFirst(Planet.class);
    }
  }

}