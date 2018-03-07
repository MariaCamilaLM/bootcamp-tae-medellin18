package com.glb.bootcamp.tae.junit;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized;

public class MyRunner extends Parameterized {

    public MyRunner(Class<?> clazz) throws Throwable {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new MyListener());
        super.run(notifier);
    }

    class MyListener extends RunListener {
        @Override
        public void testStarted(Description description) {
            System.out.println("The test:'" + description.getMethodName() + "' started and everybody is happy!");
        }
    }
}
