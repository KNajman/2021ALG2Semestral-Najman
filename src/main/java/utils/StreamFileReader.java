package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author najma
 */
public class StreamFileReader {

    public List<String[]> readFile(File file, String regexSeparator, boolean header) throws IOException {
        List<String[]> data =
          Files.lines(Paths.get(file.getPath()))
                .map(line -> line.split(regexSeparator))
                .collect(Collectors.toList());
        if(header){
            data.remove(0);
        }
        return data;
    }
}
    