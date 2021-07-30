package src.saisyu;
import java.util.Random;

public class Ship {
    int[][] field={{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
    int[] shiphp={3,3,3};
    int turn=1;
    Random ra=new Random();

    public void a0(){
        while(true){
            int x0=ra.nextInt(5);
            int y0=ra.nextInt(5);
            if(field[x0][y0]==3){
                field[x0][y0]=0;
                break;
            }
        }
    }
    public void b1(){
        while(true){
            int x1=ra.nextInt(5);
            int y1=ra.nextInt(5);
            if(field[x1][y1]==3){
                field[x1][y1]=1;
                break;
            }
        }
    }
    public void c2(){
        while(true){
            int x2=ra.nextInt(5);
            int y2=ra.nextInt(5);
            if(field[x2][y2]==3){
                field[x2][y2]=2;
                break;
            }
        }
    }

    public void hp(){
        System.out.printf("-----[ターン%d]-----\n",turn);
        if(shiphp[0]!=0){
            System.out.println("船１：生きてる");
        }else{
            System.out.println("船１：撃沈");
        }
        if(shiphp[1]!=0){
            System.out.println("船２：生きてる");
        }else{
            System.out.println("船２：撃沈");
        }
        if(shiphp[2]!=0){
            System.out.println("船３：生きてる");
        }else{
            System.out.println("船３：撃沈");
        }
        turn++;
    }
    public void no(){
        System.out.println("付近にて敵艦無し");
    }
    public void hunt(int x,int y){
        int bom=field[x][y];
        if(bom!=3){
            shiphp[bom]=shiphp[bom]-1;
            System.out.println("着弾");
            if(shiphp[bom]==0){
                field[x][y]=3;
                bom=3;
            }
        }
        if(x==0 && y==0){
            if(field[x+1][y]!=3 || field[x][y+1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(x==0 && y==4){
            if(field[x+1][y]!=3 || field[x][y-1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(x==4 && y==0){
            if(field[x-1][y]!=3 || field[x][y+1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(x==4 && y==4){
            if(field[x-1][y]!=3 || field[x][y-1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(x==0){
            if(field[x+1][y]!=3 || field[x][y-1]!=3 || field[x][y+1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(x==4){
            if(field[x-1][y]!=3 || field[x][y-1]!=3 || field[x][y+1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(y==0){
            if(field[x-1][y]!=3 || field[x+1][y]!=3 || field[x][y+1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(y==4){
            if(field[x-1][y]!=3 || field[x+1][y]!=3 || field[x][y-1]!=3){
                System.out.println("波高し");
            }else{
                no();
            }
        }else if(field[x-1][y]!=3 || field[x+1][y]!=3 || field[x][y-1]!=3 || field[x][y+1]!=3){
            System.out.println("波高し");
        }else{
            no();
        }
        if(bom==0){
            a0();
            field[x][y]=3;
            System.out.println("敵艦移動");
        }else if(bom==1){
            b1();
            field[x][y]=3;
            System.out.println("敵艦移動");
        }else if(bom==2){
            c2();
            field[x][y]=3;
            System.out.println("敵艦移動");
        }
    }
}
