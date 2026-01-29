import java.io.*;

interface BackupSerializable extends Serializable {
}

class UserData implements BackupSerializable {
    private String username;
    private String email;
    
    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}

class SystemConfig implements BackupSerializable {
    private String configName;
    private String value;
    
    public SystemConfig(String configName, String value) {
        this.configName = configName;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "SystemConfig{configName='" + configName + "', value='" + value + "'}";
    }
}

public class DataSerialization {
    public static void backupObject(BackupSerializable obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("Backup created: " + filename);
        } catch (IOException e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }
    
    public static BackupSerializable restoreObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (BackupSerializable) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Restore failed: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        UserData user = new UserData("john_doe", "john@example.com");
        SystemConfig config = new SystemConfig("theme", "dark");
        
        backupObject(user, "user_backup.ser");
        backupObject(config, "config_backup.ser");
        
        UserData restoredUser = (UserData) restoreObject("user_backup.ser");
        SystemConfig restoredConfig = (SystemConfig) restoreObject("config_backup.ser");
        
        System.out.println("Restored: " + restoredUser);
        System.out.println("Restored: " + restoredConfig);
    }
}