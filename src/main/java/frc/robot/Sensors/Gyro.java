package frc.robot.Sensors;
import com.analog.adis16448.frc.ADIS16448_IMU;

public class Gyro {

    public static ADIS16448_IMU gyro = new ADIS16448_IMU();

    public static double gyroXangle() {
     return gyro.getGyroAngleX();
    }
    public static double gyroYangle() {
        return gyro.getGyroAngleY();
    }
    public static double gyroZangle() {
        return gyro.getGyroAngleZ();
    }
}