package main;

import com.skype.Profile;
import com.skype.Skype;
import com.skype.SkypeException;

/**
 * Created by MuhammaD on 11.12.2014.
 */
public class Logic implements Runnable{


    Boolean dnd = false;
    Boolean away = false;
    Boolean online = false;
    Boolean invisible = false;
    static Boolean isRunning = true;
    static int interval = 1000;
    public Logic(){
        isRunning = false;
    }
    public Logic(int interval){
        Logic.interval = interval;
    }

    public Logic(Boolean dnd, Boolean away, Boolean online, Boolean invisible){
        this.dnd =dnd;
        this.away =away;
        this.online =online;
        this.invisible =invisible;
        isRunning = true;

    }


    public void run()  {
        Skype.setDaemon(false);

        while (isRunning) {
            if (dnd&&isRunning) {
                setStatus(Profile.Status.DND);
                pause();
            }
            if (away&&isRunning) {
                setStatus(Profile.Status.AWAY);
                pause();
            }
            if (online&&isRunning) {
                setStatus(Profile.Status.ONLINE);
                pause();
            }
            if (invisible&&isRunning) {
                setStatus(Profile.Status.INVISIBLE);
                pause();
            }
        }
}
    private void pause(){
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void setStatus(Profile.Status status){
        try {
            Skype.getProfile().setStatus(status);
        } catch (SkypeException e) {
            e.printStackTrace();
        }
    }
}
