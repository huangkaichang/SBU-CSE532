import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaryStdDev {

    private Connection con = null;

    public void setDBConnection(String url, String user, String password) {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printQueryResult(String sql) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {//USER, EMAIL, COMMENT, DATE
            int sum_x = 0;
            int count;
            double result = 0;
            List<Double> salary = new ArrayList<>();
            while (rs.next()) {
                double curSalary = rs.getDouble("Salary");
                salary.add(curSalary);
            }
            count = salary.size();
            for(int i=0; i<count; i++) {
                sum_x += salary.get(i);
            }
            int mean = sum_x/count;
            for(int i=0; i<count; i++) {
                result += Math.pow(salary.get(i)-mean, 2);
            }
            System.out.println(Math.sqrt(result/count));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String databasename = args[0];
        String tablename = args[1];
        String login = args[2];
        String password = args[3];
        StringBuilder sb1 = new StringBuilder();
        String dbURL = sb1.append("jdbc:db2://localhost:50000/").append(databasename).toString();
        
//        String login = "db2inst1";
//        String password = "5067";

        StringBuilder sb2 = new StringBuilder();
        String sql = sb2.append("SELECT Salary FROM ").append(tablename).toString();

        SalaryStdDev demo = new SalaryStdDev();
        demo.setDBConnection(dbURL, login, password);

        demo.printQueryResult(sql);
    }
}