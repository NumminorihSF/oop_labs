package ru.kpetryaev.scene;

class Ball {
    int x = 250;
    int y = 250;
    int flowX = 1;
    int flowY = 1;
    int startX = 250;
    int startY = 250;
    int rad = 5;


    Ball(){}

    Ball(int x, int y){
        this.x = this.startX = x;
        this.y = this.startY = y;
    }

    Ball(int x, int y, int rad){
        this.x = this.startX = x;
        this.y = this.startY = y;
        this.rad = rad;
    }

    int getX(){
        return this.x;
    }

    int getMoveX(){
        return this.x - this.startX;
    }

    int getY(){
        return this.y;
    }

    int getMoveY(){
        return this.y - this.startY ;
    }

    int getRad(){
        return this.rad;
    }

    private int correctFlow(int cord, int min, int max, int flow){
        if (cord - rad <= min){
            return Math.abs(flow);
        }
        if (cord + rad >= max){
            return -Math.abs(flow);
        }
        return flow;
    }

    void move(int minX, int maxX, int minY, int maxY){
        flowX = correctFlow(x, minX, maxX, flowX);
        flowY = correctFlow(y, minY, maxY, flowY);
        x += flowX;
        y += flowY;
    }

}