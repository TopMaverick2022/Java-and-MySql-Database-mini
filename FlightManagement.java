import java.util.*;
import java.sql.*;
class jet{
    Scanner s=new Scanner(System.in);
   public void add(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maverick", "root", "");
            Statement st=con.createStatement();
            System.out.println("Enter Traveler_id");
            String tId=s.nextLine();
            System.out.println("Enter TravelerName");
            String tName=s.nextLine();
            System.out.println("Enter Source");
            String tSrc=s.nextLine();
            System.out.println("Enter Destination");
            String tDest=s.nextLine();
            System.out.println("Enter Price");
            String tPrice=s.nextLine();
            System.out.println("Enter Distance,");
            String tDist=s.nextLine();
            System.out.println("Enter Booked_Status");
            String tStat=s.nextLine();
            String qry="insert into airline values("+tId+",'"+tName+"','"+tSrc+"','"+tDest+"',"+tPrice+","+tDist+",'"+tStat+"');";
            st.executeUpdate(qry);
            System.out.println("RecordS inserted Successfully!!");
        }
        catch(ClassNotFoundException e){}
        catch(SQLException e){}

    }
   public void display(){ try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maverick", "root", "");
        Statement st=con.createStatement();
        ResultSet r=st.executeQuery("select * from airline");
        System.out.println("id | Traveler | Source | Destination | Price | Distance | Booked_Status"+"\n");   
        while (r.next()) {
            System.out.println(r.getInt(1)+"| "+r.getString(2)+"| "+r.getString(3)+"| "+r.getString(4)+"| "+r.getInt(5)+"| "+r.getInt(6)+"| "+r.getString(7));
            }
    }
    catch(ClassNotFoundException e){}
    catch(SQLException e){}

    }
   public void update(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maverick", "root", "");
            Statement st=con.createStatement();
            System.out.println("Enter Traveler_id");
            String tId=s.nextLine();
            System.out.println("Enter TravelerName");
            String tName=s.nextLine();
            System.out.println("Enter Source");
            String tSrc=s.nextLine();
            System.out.println("Enter Destination");
            String tDest=s.nextLine();
            System.out.println("Enter Price");
            String tPrice=s.nextLine();
            System.out.println("Enter Distance,");
            String tDist=s.nextLine();
            System.out.println("Enter Booked_Status");
            String tStat=s.nextLine();
            st.executeUpdate("update airline set Traveler='"+tName+"',Source='"+tSrc+"',Destination='"+tDest+"',Price="+tPrice+",Distance="+tDist+",Booked_Status='"+tStat+"' where Travel_id="+tId+";"); 
            System.out.println("Record in Travel_id"+tId+" is Updated");
        }
        catch(ClassNotFoundException e){}
        catch(SQLException e){}


    }
    public void find(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maverick", "root", "");
            Statement st=con.createStatement();
            System.out.println("Enter Traveler_id :");
            String tId=s.nextLine();
            ResultSet r=st.executeQuery("select * from airline where Travel_id="+tId+";");
            while (r.next()) {
                System.out.println(r.getInt(1)+"| "+r.getString(2)+"| "+r.getString(3)+"| "+r.getString(4)+"| "+r.getInt(5)+"| "+r.getInt(6)+"| "+r.getString(7));
                }
        }
        catch(ClassNotFoundException e){}
        catch(SQLException e){}


    }
   public void delete(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maverick", "root", "");
            Statement st=con.createStatement();
            System.out.println("Enter Traveler_id :");
            String tId=s.nextLine();
            String qry= "delete from airline where Travel_id="+tId+";";
            st.executeUpdate(qry);
            System.out.println("Record in Travel_id"+tId+" is deleted");
        }
        catch(ClassNotFoundException e){}
        catch(SQLException e){}


    }
}

public class FlightManagement {
       public static void main(String[] args) {
        jet j=new jet();
        Scanner s=new Scanner(System.in);
        int ch;
        do{
            System.out.println("Enter the choice:\n 1.Add-Record\n 2.Display All Record\n 3.Modify-Record\n 4.Display Specific Record\n 5.Delete a record\n 6.enter 0 to exit");
             ch=s.nextInt();
            switch (ch) {
                case 1:
                    j.add();
                    break;
                case 2:
                    j.display();
                    break;
                case 3:
                    j.update();
                    break;
                case 4:
                    j.find();
                    break;
                case 5:
                    j.delete();
                    break;
                default:
                    System.out.println("Thankyou For Registering !!!!!");
                    break;
            }

        }while(ch!=0);
    }
}