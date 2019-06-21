package broadcast;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.example.notifiation.R;

import createChannel.CreateChannel;

public class BroadcastReceiverExample extends BroadcastReceiver {

    private NotificationManagerCompat notificationManagerCompat;
    Context context;


    public BroadcastReceiverExample(Context context) {
        this.context = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean noConnectivity;

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false
            );

            if (noConnectivity){
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
                    DisplayNotification();
            }else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                DisplayNotification2();

            }
        }
    }

    int id=1;
    private void DisplayNotification(){
        Notification notification=new NotificationCompat.Builder(context, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_wifi_black_24dp)
                .setContentTitle("No connection")
                .setContentText("No connection, Please connect")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);
        id++;
    }


    private void DisplayNotification2(){
        Notification notification=new NotificationCompat.Builder(context,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_wifi_black_24dp)
                .setContentTitle("Connected")
                .setContentText("You have been connected to a network")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2,notification);
        id++;
    }
}
