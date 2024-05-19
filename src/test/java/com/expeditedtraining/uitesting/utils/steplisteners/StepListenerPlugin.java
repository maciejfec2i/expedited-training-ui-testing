package com.expeditedtraining.uitesting.utils.steplisteners;

import com.expeditedtraining.uitesting.utils.logging.Colour;
import com.expeditedtraining.uitesting.utils.logging.Colourify;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Custom {@link io.cucumber} plugin for logging test case details to the console. This needs to be added to the
 * {@link org.junit.platform.suite.api.ConfigurationParameters} annotation value string in the
 * {@link com.expeditedtraining.uitesting.CucumberTestSuite}.<br><br>
 *
 * See {@link io.cucumber.core.plugin.SerenityReporterParallel} to get an idea of the different event handlers.
 *
 * @author Maciej Fec
 * @version 13/05/2024
 */
public class StepListenerPlugin implements Plugin, ConcurrentEventListener {

    private final Logger LOGGER = LoggerFactory.getLogger(StepListenerPlugin.class);

    private final EventHandler<TestStepStarted> testStepStartedEventHandler = this::testStepStarted;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, testStepStartedEventHandler);
    }

    private void testStepStarted(TestStepStarted event) {
        if(!(event.getTestStep() instanceof HookTestStep)) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            logTestStep(testStep);
        }
    }

    private void logTestStep(PickleStepTestStep testStep) {
        String testStepText = testStep.getStep().getKeyword() + testStep.getStep().getText();

        LOGGER.info(Colourify.theText("STEP STARTED").with(Colour.CYAN) + " {}", testStepText);
    }
}
