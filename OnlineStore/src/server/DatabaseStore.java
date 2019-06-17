package server;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseStore {
	private static String USER = "CREATE TABLE Users ( userID int NOT NULL, DOB DATE, firstName varchar(255), lastName varchar(255), email varchar(255), gender varchar(255), root boolean NOT NULL, userStatus int, PRIMARY KEY (userID));";
	private static String ITEM = "CREATE TABLE Item (itemID int NOT NULL, price decimal, postDate int, title varchar(255), itemDescription varchar(255), PRIMARY KEY (itemID) );";
	private static String REVIEW = "CREATE TABLE Review ( reviewID int NOT NULL, userID int NOT NULL, itemID int NOT NULL, rating varchar(255), dateOfReview DATE, PRIMARY KEY (reviewID),  FOREIGN KEY (userID) REFERENCES Users(userID),FOREIGN KEY (itemID) REFERENCES Item(itemID) );";
	private static String CATEGORY = "CREATE TABLE Category (categoryID int NOT NULL, itemID int NOT NULL, titleOfCategory varchar(255), PRIMARY KEY (categoryID), FOREIGN KEY (itemID) REFERENCES Item(itemID));";
	private static String TRANSACTION = "CREATE TABLE Transactions (transactionID int NOT NULL, sellerID int NOT NULL, buyerID int NOT NULL, itemID int NOT NULL, PRIMARY KEY (transactionID), FOREIGN KEY (sellerID) REFERENCES Users(userID), FOREIGN KEY (buyerID) REFERENCES Users(userID), FOREIGN KEY (itemID) REFERENCES Item(itemID));";
	private static String NEWUSER = "insert into Users (userID, DOB, firstName, lastName, email, gender, root, userStatus) values(?,?,?,?,?,?,?,?);";
	public void create() {
		Connection connect = null;
		try {
        	//Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/testdb?" + "user=john&password=pass1234");
            
            PreparedStatement drop = connect.prepareStatement("drop table Users");
            drop.execute();
            PreparedStatement stmt = connect.prepareStatement(USER);
            stmt.execute();
            User user = new User(1, "12/4/1994", "Mike", "John", "mike@email.com", "Male", false, 4);
            insertUser(connect, user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		finally {
			try {
				connect.close();
			} catch(Exception e) {
			}
		
		}
	}
	private void insertUser(Connection connect, User user) throws SQLException, ParseException {
		PreparedStatement stmt = connect.prepareStatement(NEWUSER);
		stmt.setInt(1, user.getUserID());
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		java.util.Date dt = sdf.parse(user.getDOB());
		Date DOB = new Date(dt.getTime());
		stmt.setDate(2, DOB);
		stmt.setString(3, user.getFirstName());
		stmt.setString(4, user.getLastName());
		stmt.setString(5, user.getEmail());
		stmt.setString(6, user.getGender());
		stmt.setBoolean(7, user.isRoot());
		stmt.setInt(8, user.getUserStatus());
		stmt.execute();
		
		
	}
	public static void main(String[] args) {
		DatabaseStore db = new DatabaseStore();
		db.create();
	}



}
