import java.util.List;

public class TestDeviceDao {

    public static void main(String[] args) {

        DeviceDao deviceDao = new DeviceDao();
        List<Device> deviceList = deviceDao.getAllDeviceWIthHearthRateAndGps("paolo");

        for (Device device : deviceList){
            String deviceManufacturer = device.getDeviceManufacturer().toLowerCase();
            String deviceModel = device.getDeviceModel().toUpperCase();
            System.out.println(deviceManufacturer + deviceModel);
        }
    }
}

