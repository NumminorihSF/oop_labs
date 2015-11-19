package ru.kpetryaev.scene;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by NumminorihSF on 18.09.2015.
 */
public class BallSpaceModel extends Observable {
    ArrayList<Ball> balls = new ArrayList<Ball>();
    BallSpaceThread ballSpaceThread;


    private int speed;
    private int width;
    private int height;

    boolean canRun = false;
    void start(){
        if (canRun){
            return;
        }
        canRun = true;
            ballSpaceThread = new BallSpaceThread(this);
            ballSpaceThread.moveWithSpeed(speed).start();
    }
    void stop(){
        canRun = false;
    }

    void setSpeed(int speed){
        this.speed = speed;
    }

    synchronized void tryMove(){
        if (canRun){
            for (int i = 0; i < balls.size(); i++){
                balls.get(i).move(0, width, 0, height);
            }
            this.setChanged();
            this.notifyObservers();
            canRun = false;
            this.start();
        }
    }


    BallSpaceModel(int speed){
        this.speed = speed;
        balls.add(new Ball());
    }

    BallSpaceModel(double x, double y){
        width = ((Double)x).intValue();
        height = ((Double)y).intValue();
        this.speed = 1;
    }

    public void setSizes(double x, double y){
        width = ((Double)x).intValue();
        height = ((Double)y).intValue();
    }

    public int size(){
        return balls.size();
    }

    public int getX(int i){
        return balls.get(i).getX();
    }
    public int getY(int i){
        return balls.get(i).getY();
    }

    public int getMoveX(int i){
        return balls.get(i).getMoveX();
    }
    public int getMoveY(int i){
        return balls.get(i).getMoveY();
    }

    public int getRad(int i){
        return balls.get(i).getRad();
    }

    public void addBall(int x, int y, int rad){
        balls.add(new Ball(x, y, rad));
    }
}
