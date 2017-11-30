
package game1111;

//import static game1111.Field.mas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Field{
    static int mas[][] = new int [10][10];
    void inField(int obs){
        int k = 0;
        while(k<obs){
            mas[(int)(Math.random()*10)][(int)(Math.random()*10)]=1;
            if (mas[9][0] != 1 && mas[0][9] != 1)
                k++;  
        }    
    }
    void printField(){
        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas.length; j++){
                System.out.print(mas[i][j] + "\t");
            } 
            System.out.println();
        }
    }
}

class Hero{
    int x=0, y=9, step = 0;
    
    /*Hero(){
        x = 0;
        y = 9;
        mas[y][x]=2;

    }*/
    void hh(){
        Field.mas[y][x]=2;
    }
    
    
}

class Game{
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
    
    
    void move(){
        
        //mas[h.y][h.x]=2;
        switch(getDirection()){
            case 8: h.y--; break;
            case 2: h.y++; break;
            case 4: h.x--; break;
            case 6: h.x++; break;
            default: System.out.println("Неверное направление!");
        }
       // System.out.println(h.x);
    }
    
    void startGame(){
        f.inField(5);
        while(h.x!=9 & h.y!=0){
        f.printField();
        h.hh();
        //mas[h.y][h.x]=2;
        //int b = getDirection();
        //System.out.println(b);
        move();
        }
    }
    
}

public class Game1111 {

    public static void main(String[] args) {
       Game gm = new Game();
       gm.startGame();
    }
   private class GITASD {} 
}

//  леция дискретка проверка
    
