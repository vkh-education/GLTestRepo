package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class TestNGListener implements ITestListener {
    private static final Logger log = Logger.getLogger( TestNGListener.class.getName() );

    @Override
    public void onTestStart(ITestResult result) {
        log.info( "\n ====================================\nTEST STARTED: \n- "
                + result.getMethod().getRealClass() + "\n- method " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("\n====================================\n TEST PASSED:\n- "
                + result.getMethod().getTestClass() + "\n- method " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("\n====================================\n TEST FAILED:\n- "
                + result.getMethod().getTestClass()
                + "\n- method " + result.getMethod().getMethodName()
                + "\n" + result.getThrowable().getLocalizedMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("\n====================================\n TEST RETEST:\n- "
                + result.getMethod().getTestClass() + "\n- method " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart( ITestContext iTestContext ) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }

}
