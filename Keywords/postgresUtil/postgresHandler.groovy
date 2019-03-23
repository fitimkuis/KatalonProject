package postgresUtil

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException
import java.sql.Statement;

import com.kms.katalon.core.annotation.Keyword

public class postgresHandler {

	Connection c = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	@Keyword
	public int getRowCount(){

		int count = 0
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet r = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM COMPANY");
			r.next();
			count = r.getInt("rowcount");
			r.close();
			System.out.println("MyTable has " + count + " row(s).");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return count
	}

	@Keyword
	public void createTable(){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "CREATE TABLE COMPANY " +
					"(ID INT PRIMARY KEY     NOT NULL," +
					" NAME           TEXT    NOT NULL, " +
					" AGE            INT     NOT NULL, " +
					" ADDRESS        CHAR(50), " +
					" SALARY         REAL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}

	@Keyword
	public void insertIntoFromList(List<String> data, int indexStart){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = ""
			//int x = 5
			int index = 0 //list index start from 0

			String SQL = "INSERT INTO COMPANY VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = c.prepareStatement(SQL);


			for (int x = 0; x < data.size(); x++){
				String fName = data.get(index).toString()
				println fName
				index++
				int age = Integer.parseInt(data.get(index))
				println age
				index++
				String city = data.get(index).toString()
				println city
				index++
				double salary = Double.valueOf(data.get(index))
				println salary
				index++
				String ssn = data.get(index).toString()
				println ssn
				pstmt.setInt(1, indexStart);
				pstmt.setString(2, fName);
				pstmt.setInt(3, age)
				pstmt.setString(4, city);
				pstmt.setDouble(5, salary);
				pstmt.setString(6, ssn);
				pstmt.executeUpdate();
				indexStart++
				index++
				if (index >= 40){
					break
				}
			}


			pstmt.close();
			//stmt.executeUpdate(sql);

			//stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	@Keyword
	public void insertInto(){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 32, 'California', 20000.00 );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
			stmt.executeUpdate(sql);

			sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
			stmt.executeUpdate(sql);

			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Records created successfully");
	}

	@Keyword
	public void selectData(){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String  name = rs.getString("name");
				int age  = rs.getInt("age");
				String  address = rs.getString("address");
				float salary = rs.getFloat("salary");
				String  ssn = rs.getString("ssn");
				System.out.println( "ID = " + id );
				System.out.println( "NAME = " + name );
				System.out.println( "AGE = " + age );
				System.out.println( "ADDRESS = " + address );
				System.out.println( "SALARY = " + salary );
				System.out.println( "SSN = " + ssn );
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
	
	@Keyword
	public void updateSsn(List<String> ssn){

		int index = 0

		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		String SQL = "UPDATE COMPANY SET ssn = ? WHERE id = ?";
		pstmt = c.prepareStatement(SQL)
		try{
			
			for (int x = 0; x < ssn.size(); x++){
				String ssnString = ssn.get(index).toString()
				//println ssnString
				pstmt.setString(1, ssnString);
				pstmt.setInt(2, x)
				pstmt.executeUpdate();
				c.commit();
				index++
				if (index == 54){
					break
				}
			}

			pstmt.close();
			c.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Operation done successfully");
	}
	
	@Keyword
	public void updateColumn(int val, int id, Object arg){


		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");


		try{
			switch (val){
				
				case 1: String SQL = "UPDATE COMPANY SET name = ? WHERE id = ?";
					pstmt = c.prepareStatement(SQL);
					pstmt.setFloat(1, arg);
					pstmt.setInt(2, id);
					break;
				case 2:	String SQL = "UPDATE COMPANY SET age = ? WHERE id = ?";
					pstmt = c.prepareStatement(SQL)
					pstmt.setFloat(1, arg)
					pstmt.setInt(2, id)
					break
				case 3: String SQL = "UPDATE COMPANY SET address = ? WHERE id = ?";
					pstmt = c.prepareStatement(SQL)
					pstmt.setFloat(1, arg)
					pstmt.setInt(2, id)
					break
				case 4: String SQL = "UPDATE COMPANY SET salary = ? WHERE id = ?";
					pstmt = c.prepareStatement(SQL)
					pstmt.setFloat(1, arg)
					pstmt.setInt(2, id)
					break
				case 5: String SQL = "UPDATE COMPANY SET ssn = ? WHERE id = ?";
					pstmt = c.prepareStatement(SQL)
					pstmt.setFloat(1, arg)
					pstmt.setInt(2, id)
					break
				
			}
			pstmt.executeUpdate();
			c.commit();

			pstmt.close();
			c.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Operation done successfully");
	}

	@Keyword
	public void updateSalary(int id, float salary){

		boolean update = true

		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		String SQL = "UPDATE COMPANY SET salary = ? WHERE id = ?";
		pstmt = c.prepareStatement(SQL)
		try{
			pstmt.setFloat(1, salary)
			pstmt.setInt(2, id)

			pstmt.executeUpdate();
			c.commit();

			pstmt.close();
			c.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Operation done successfully");
	}

	@Keyword
	public void updateExactData(int id, String fName, int age, String city, float salary, String ssn){

		boolean update = true

		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
		c.setAutoCommit(false);
		System.out.println("Opened database successfully");

		String SQL = "UPDATE COMPANY SET name = ?, age = ?, address = ?, salary = ?, SET ssn WHERE id = ?";
		pstmt = c.prepareStatement(SQL)
		try{
			pstmt.setString(1, fName);
			pstmt.setInt(2, age);
			pstmt.setString(3, city);
			pstmt.setFloat(4, salary)
			pstmt.setString(5, ssn);
			pstmt.setInt(6, id)

			pstmt.executeUpdate();
			c.commit();

			pstmt.close();
			c.close();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Operation done successfully");
	}

	@Keyword
	public void updateData(){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
			stmt.executeUpdate(sql);
			c.commit();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String  name = rs.getString("name");
				int age  = rs.getInt("age");
				String  address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println( "ID = " + id );
				System.out.println( "NAME = " + name );
				System.out.println( "AGE = " + age );
				System.out.println( "ADDRESS = " + address );
				System.out.println( "SALARY = " + salary );
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}

	@Keyword
	public void deleleRowData(){

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			String sql = "DELETE from COMPANY where ID = 2;";
			stmt.executeUpdate(sql);
			c.commit();

			ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
			while ( rs.next() ) {
				int id = rs.getInt("id");
				String  name = rs.getString("name");
				int age  = rs.getInt("age");
				String  address = rs.getString("address");
				float salary = rs.getFloat("salary");
				System.out.println( "ID = " + id );
				System.out.println( "NAME = " + name );
				System.out.println( "AGE = " + age );
				System.out.println( "ADDRESS = " + address );
				System.out.println( "SALARY = " + salary );
				System.out.println();
			}
			rs.close();
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Operation done successfully");
	}
}
