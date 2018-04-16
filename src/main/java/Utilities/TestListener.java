package Utilities;

import Pages.BaseExtendablePage;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

/**
 * Created by Dawidek on 2018-02-07.
 */
public class TestListener extends TestListenerAdapter {

    public static TestsResults testsresults = new TestsResults();

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println(testResult.getName() + " was successful.");
        testsresults.incrementPassed();
        System.out.println("PASSED TESTS " + testsresults.getPassed());
        System.out.println("TOTAL TESTS " + testsresults.getTotalTests());
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        System.out.println(testResult.getName() + " was skipped.");
        testsresults.incrementSkipped();
        System.out.println("SKIPPED TESTS " + testsresults.getSkipped());
        System.out.println("TOTAL TESTS " + testsresults.getTotalTests());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println(testResult.getName() + " was failure. \n Throwable " + testResult.getThrowable().getMessage());
        BaseExtendablePage.captureScreenshot(RandomValuesGenerator.getCurrentDate());
        testsresults.incrementFailed();
        System.out.println("FAILED TESTS " + testsresults.getFailed());
        System.out.println("TOTAL TESTS " + testsresults.getTotalTests());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        try {
            testsresults.writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
