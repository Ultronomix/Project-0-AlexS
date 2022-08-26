package Repository;

import Models.Bike;
import util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeRepository  implements  DAO<Bike> {
    @Override
    public Bike create(Bike bike){
        String sql = "insert into bikes(name,color,year) values(?,?,?,?)";
        try(Connection connection = ConnectionUtility.getInstance()){
            PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, bike.getName());
                stmt.setString(2, bike.getColor());
                stmt.setString(3, bike.getYear());

                if (stmt.executeUpdate() == 1){
                    return bike;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Bike> getAll(){
        List<Bike> bikes = new ArrayList<>();
        String sql = "select *from bikes";
        try(Connection connection = ConnectionUtility.getInstance()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Bike bike = new Bike();
                bike.setName(rs.getString("name"));
                bike.setColor(rs.getString("color"));
                bike.setYear(rs.getString("year"));

                bikes.add(bike);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bikes;

    }
}

