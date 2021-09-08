package model;

import javax.swing.*;
import java.util.*;

public class EncryptionProgram {

    private JFrame frame;
    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private char[] letters;

    public EncryptionProgram(){
        frame = new gui.TextEncryptor(this);
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';

        newKey();

    }


    private void newKey(){

        character = ' ';
        list.clear();
        shuffledList.clear();

        for(int i=32;i<127;i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("*A new Key has been generated*");
    }
    private void getKey(){
        System.out.println("Key : ");
        for(Character x:list){
            System.out.print(x);
        }
        System.out.println();
        for(Character x:shuffledList){
            System.out.print(x);
        }
        System.out.println();
    }

    public String encrypt(String text){

        letters = text.toCharArray();

        for(int i=0;i<letters.length;i++){

            for(int j=0;j<list.size();j++){
                if(letters[i]==list.get(j)){
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }

        return displayResult(letters);

    }

    public String decrypt(String text){
        letters = text.toCharArray();

        for(int i=0;i<letters.length;i++){

            for(int j=0;j<shuffledList.size();j++){
                if(letters[i]==shuffledList.get(j)){
                    letters[i]=list.get(j);
                    break;
                }
            }
        }

        return displayResult(letters);
    }

    private void quit(){
        System.out.println("Good bye :)");
        System.exit(0);
    }


    private String displayResult(char[] letters){
        String result = new String();

        for(char x : letters){
            result += x;
        }

        return result;
    }

}