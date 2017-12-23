package game1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Field{
    static int  mas[][] = new int [10][10];//написать заполнение массива нулями 
     
    void inField(int obs){//и присваивать их индексы переменными что б
        int k = 0;// потом обращяться к ним чере f. а не h.
        while(k<obs){
            mas[(int)(Math.random()*10)][(int)(Math.random()*10)]=1;
            if (mas[9][0] != 1 && mas[0][9] != 1) {  
                k++;
            }  
        }    
    }
    void printField(){
        for (int[] ma : mas) {// Тут переписал цикл
            for (int j = 0; j < mas.length; j++) {
                System.out.print(ma[j] + "\t");
            } 
            System.out.println();
        }
    }
}

class Hero{
    int x=0, y=9, step = 0;
    void hh(){
        Field.mas[y][x]=2;
        
    }
    
    
}

class Game{

    Game() {

    }
    private int getDirection(){
        int direction = 0;
        

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            direction = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.out.println("Ошибка ввода!!!");
        }

        return direction;
    }
    
    Hero h = new Hero();
    Field f = new Field();
    
    void move(){  int y1, y2, x1, x2;  
        switch(getDirection()){
            case 8: y1=h.y; h.y--; Field.mas[y1][h.x]=0; break ;///добил идею свою наконец 
            case 2: y2=h.y; h.y++; Field.mas[y2][h.x]=0; break;// блять ебался с этим пока наконец не понял,
            case 4: x1=h.x; h.x--; Field.mas[h.y][x1]=0; break;///что ты массив задал через y;x ,а не 
            case 6: x2=h.x; h.x++; Field.mas[h.y][x2]=0; break;// через x;y 
            default: System.out.println("Неверное направление!");
        
        }
       // System.out.println(h.x);
    }
    
    void startGame(){
        f.inField(5);
        while(h.x!=9 || h.y!=0){
            h.hh();
            f.printField();
            move(); 
            
        }
    }
    
}

public class Game1111 {

    public static void main(String[] args) {
       Game gm = new Game();
       gm.startGame();
    }
    //228
}
