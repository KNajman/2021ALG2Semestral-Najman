package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author najma
 */
public class TextFileReader {
    
    public List<String[]> readFile(File file, String regexSeparator, boolean header) throws IOException{
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            if(header){
                br.readLine(); //preskoceni zahlavi 
            }
            while((line = br.readLine()) != null){
                String[] parts = line.split(regexSeparator);
                data.add(parts);
            }
        }
        return data;
    }
}
