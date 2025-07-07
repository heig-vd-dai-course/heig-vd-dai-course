package ch.heigvd.dai.users;

public class User {

  public Integer id;
  public String firstName;
  public String lastName;
  public String email;
  public String password;

  public User() {
    // Empty constructor for serialisation/deserialization
  }
}
