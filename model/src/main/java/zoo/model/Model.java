package zoo.model;

import java.sql.*;
import java.util.ArrayList;

public class Model {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "8";

    public static void addMySQLToClassPath() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static void createDbUserTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS zoo("
                + "ANIMAL_ID INT(5) NOT NULL AUTO_INCREMENT, "
                + "ANIMAL_NAME VARCHAR(20) NOT NULL, "
                + "ANIMAL_AGE INT NOT NULL, "
                + "ANIMAL_CLASS VARCHAR (20) NOT NULL, "
                + "PRIMARY KEY (ANIMAL_ID) "
                + ")";
        try (Connection dbConnection = getConnection();
             Statement statement = dbConnection.createStatement()) {
            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"zoo\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modelStub(){
        System.out.println("modelStub works");
    }

    public static void insertInto(String animalName, int animalAge, String animalClass){
//        createDbUserTable();

        String insert = "INSERT INTO ZOO (ANIMAL_NAME, ANIMAL_AGE, ANIMAL_CLASS) "
                + "VALUES(?, ?, ?)";

        try (Connection dbConnection = getConnection();
             PreparedStatement preparedStatement = dbConnection.prepareStatement(insert)) {
            // выполнить SQL запрос
            preparedStatement.setString(1, animalName);
            preparedStatement.setInt(2, animalAge);
            preparedStatement.setString(3, animalClass);
            preparedStatement.executeUpdate();
            System.out.println("The animal is inserted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Animal> showAnimals(){
//        createDbUserTable();
        ArrayList<Animal> animalsList = new ArrayList<>();

        try(Connection dbConnection = getConnection();
            PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM ZOO");){
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Animal animal = new Animal();
                animal.setAnimalName(resultSet.getString(2));
                animal.setAnimalAge(resultSet.getInt(3));
                animal.setAnimalClass(resultSet.getString(4));
     //           System.out.println(animal.toString());
                animalsList.add(animal);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return animalsList;
    }
}