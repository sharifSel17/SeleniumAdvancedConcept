package seleniumAdvanced;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by Sharif on 10/18/2017.
 */
public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation result, Class testClass, Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = result.getRetryAnalyzer();

        if (retry == null)	{
            result.setRetryAnalyzer(RetryClass.class);
        }
    }
}
