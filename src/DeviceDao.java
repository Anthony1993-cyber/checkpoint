import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceDao {

    Device device = null;
    List<Device> deviceList = new ArrayList<>();
    private final String queryGetDeviceByGPSAndHeartRate = "SELECT * FROM device WHERE DEVICE_HAS_GPS != ? AND DEVICE_HAS_HEARTRATE != ? AND USERNAME = ?";
    public List<Device> getAllDeviceWIthHearthRateAndGps(String username){
        try{
            Connection connection = DriverManager.getConnection(Utilities.getUrl(), Utilities.getUser(), Utilities.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement(queryGetDeviceByGPSAndHeartRate);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, 0);
            preparedStatement.setString(3, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                device = new Device(resultSet.getString("DEVICE_PART_NUMBER"),
                        resultSet.getString("DEVICE_MANUFACTURER"),
                        resultSet.getString("DEVICE_MODEL"),
                        resultSet.getShort("DEVICE_HAS_GPS"),
                        resultSet.getShort("DEVICE_HAS_HEARTRATE"),
                        resultSet.getString("USERNAME"));
                deviceList.add(device);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deviceList;


    }
}

