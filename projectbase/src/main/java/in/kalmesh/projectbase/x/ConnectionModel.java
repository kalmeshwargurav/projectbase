package in.kalmesh.projectbase.x;

/**
 * Created by Kalmeshwar on 03 Dec 2020 at 13:18.
 */
public class ConnectionModel {
    private boolean isConnected;

    public ConnectionModel(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
    }
}