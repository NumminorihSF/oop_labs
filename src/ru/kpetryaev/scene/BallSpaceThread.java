package ru.kpetryaev.scene;

/**
 * Created by NumminorihSF on 18.09.2015.
 */
public class BallSpaceThread extends Thread {
    private BallSpaceModel model;
    private int speed;

    public BallSpaceThread(BallSpaceModel model){
        this.model = model;
    }


    @Override
    public void run(){
        try{
            sleep(1000/speed);
        }
        catch(InterruptedException e){}
        model.tryMove();
    }

    public BallSpaceThread moveWithSpeed(int speed){
        this.speed = speed;
        return this;
    }
}
