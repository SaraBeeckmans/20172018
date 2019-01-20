package com.example.sara.a20172018;

public class Game {
    public Game(){
        clearGameMatrix();
    }
    private char[][] gameMatrix = new char[3][3];
    private int stappenO=0;
    private int stappenX=0;
    private char actieveSpeler='O';


    private void clearGameMatrix(){
        for(int x = 0;x<3;x++){
            for(int y = 0;y<3;y++){
                gameMatrix[x][y] = '?';
            }
        }
    }

    public char getActifPlayer(){
        return actieveSpeler;
    }

    public String getXO(int x, int y){
        return String.valueOf(gameMatrix[x][y]);
    }
    public void setXO(int x, int y){
        if (actieveSpeler=='O'){
            setO(x,y);
        }
        else{
            setX(x,y);
        }

    }

    private void setO(int x, int y){
        gameMatrix[x][y] = 'O';
        stappenO++;
        actieveSpeler='X';
    }

    private void setX(int x, int y){
        gameMatrix[x][y] = 'X';
        stappenX++;
        actieveSpeler='O';
    }

    public void reset(){
        clearGameMatrix();
        stappenO=0;
        stappenX=0;
        actieveSpeler='O';

    }

    //wanneer O de winnaar is 'O' ...
    public char winnaar(){


        for(int x = 0; x<3;x++){
            if(gameMatrix[x][0]=='O'&&gameMatrix[x][1]=='O'&&gameMatrix[x][2]=='O'){
                return 'O';
            }
            if(gameMatrix[x][0]=='X'&&gameMatrix[x][1]=='X'&&gameMatrix[x][2]=='X'){
                return 'X';
            }
        }

        for(int y = 0; y<3;y++){
            if(gameMatrix[0][y]=='O'&&gameMatrix[1][y]=='O'&&gameMatrix[2][y]=='O'){
                return 'O';
            }
            if(gameMatrix[0][y]=='X'&&gameMatrix[1][y]=='X'&&gameMatrix[2][y]=='X'){
                return 'X';
            }
        }

        if((gameMatrix[0][2]=='X'&&gameMatrix[1][1]=='X'&&gameMatrix[2][0]=='X')||(gameMatrix[0][0]=='X'&&gameMatrix[1][1]=='X'&&gameMatrix[2][2]=='X')){
            return 'X';
        }
        if((gameMatrix[0][2]=='O'&&gameMatrix[1][1]=='O'&&gameMatrix[2][0]=='O')||(gameMatrix[0][0]=='O'&&gameMatrix[1][1]=='O'&&gameMatrix[2][2]=='O')){
            return 'O';
        }

        //gelijkspel

        for(int x = 0;x<3;x++){
            for(int y = 0;y<3;y++){
                if(gameMatrix[x][y] == '?')return '?';
            }
        }

        return 'G';

    }
}
