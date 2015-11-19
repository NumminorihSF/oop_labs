package ru.kpetryaev.lab.lab7.task2;

/**
 * Created by NumminorihSF on 19.09.2015.
 */
public class PhysicBodyMoving {
    int speed;
    int acceleration;
    int time;

    PhysicBodyMoving(int speed, int acceleration, int time){
        this.speed = speed;
        this.acceleration = acceleration;
        this.time = time;
    }

    int getPath(){
        return this.time * (this. speed + this.acceleration * this.time/2);
    }
    int getFinishSpeed(){
        return this.speed + this.acceleration * this.time;
    }
}
