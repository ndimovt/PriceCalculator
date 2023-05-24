package io.github.ndimovt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {
    private ArrayList<String> readInformation() {
        ArrayList<String> agricultureProducts = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Nikolai\\IdeaProjects\\PriceCalculator\\Agricultire.txt"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                agricultureProducts.add(line);
            }
            closingStreams(bufferedReader);
        } catch (FileNotFoundException fnf) {
            System.out.println("Missing file!");
            fnf.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return agricultureProducts;
    }
    public void showInfo(){
        ArrayList<String> information = readInformation();
        for(String info : information){
            System.out.println(info);
        }
    }
    private void closingStreams(BufferedReader bfr) throws IOException{
        if(bfr.readLine() != null){
            bfr.close();
        }
    }
}
