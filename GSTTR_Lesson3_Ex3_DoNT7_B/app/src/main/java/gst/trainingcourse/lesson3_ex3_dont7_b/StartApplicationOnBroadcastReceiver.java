package gst.trainingcourse.lesson3_ex3_dont7_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartApplicationOnBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()!= null)
        {
            if(intent.getAction().equalsIgnoreCase("action.open.app")){
                Intent intent1 = new Intent(context, MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        }
    }
}
