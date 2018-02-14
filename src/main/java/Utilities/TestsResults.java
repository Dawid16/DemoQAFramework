package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Dawidek on 2018-02-10.
 */
public class TestsResults {

    int passed;
    int skipped;
    int failed;

    public int getPassed() { return this.passed; }

    public int getSkipped(){ return this.skipped; }

    public int getFailed(){ return this.failed; }

    public int getTotalTests(){ return (this.failed + this.skipped + this.passed); }

    public void incrementPassed(){this.passed++;};

    public void incrementSkipped(){this.skipped++;};

    public void incrementFailed(){this.failed++;};

    public void writeToFile() throws IOException{
        File file = new File("D:\\DemoQA\\TestsResults\\TestsResults" + RandomValuesGenerator.getCurrentDate() + ".csv");

        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            bufferedWriter.write("PASSED: " + this.passed + "\n");
            bufferedWriter.write("SKIPPED: " + this.skipped + "\n");
            bufferedWriter.write("FAILED: " + this.failed + "\n");
            bufferedWriter.write("TOTAL: " + this.getTotalTests() + "\n");
        }
    }

}
