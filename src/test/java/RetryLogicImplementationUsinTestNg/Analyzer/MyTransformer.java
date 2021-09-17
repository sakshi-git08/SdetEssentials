package RetryLogicImplementationUsinTestNg.Analyzer;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTransformer implements IAnnotationTransformer {
    //Constructor and Method both are present in java.lang.reflect package
    public void transform(ITestAnnotation annotation, Class testClass, Constructor test, Method testMethod){

        annotation.setRetryAnalyzer(RetryAnalyzer.class); // on this class I want to use retry mechanism

    }
}
