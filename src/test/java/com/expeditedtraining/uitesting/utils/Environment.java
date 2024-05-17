package com.expeditedtraining.uitesting.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

/**
 * The purpose of this class is to provide access to singleton instances of {@link EnvironmentVariables}
 * and {@link EnvironmentSpecificConfiguration}.
 *
 * @author Maciej Fec
 * @version 09/05/2024
 */
public class Environment {

    private static EnvironmentVariables SYSTEM_ENVIRONMENT_VARIABLES_INSTANCE;
    private static EnvironmentSpecificConfiguration ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE;

    /**
     * Used for retrieving the system environment variables, including variables passed in from:<br>
     * <ul>
     *     <li>Command Line</li>
     *     <li>serenity.conf file</li>
     * </ul>
     *
     * @return Instance of {@link EnvironmentVariables}
     *
     * @author Maciej Fec
     * @Version 09/05/2024
     */
    public static EnvironmentVariables getSystemEnvironmentVariables() {
        if(SYSTEM_ENVIRONMENT_VARIABLES_INSTANCE == null) {
            SYSTEM_ENVIRONMENT_VARIABLES_INSTANCE = SystemEnvironmentVariables.createEnvironmentVariables();
        }

        return SYSTEM_ENVIRONMENT_VARIABLES_INSTANCE;
    }

    /**
     * Used for retrieving environment specific configurations defined under environments in the serenity.conf file.
     *
     * @return Instance of {@link EnvironmentSpecificConfiguration}
     *
     * @author Maciej Fec
     * @version 09/05/2024
     */
    public static EnvironmentSpecificConfiguration getEnvironmentSpecificConfiguration() {
        if(ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE == null) {
            ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE = EnvironmentSpecificConfiguration.from(getSystemEnvironmentVariables());
        }

        return ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE;
    }
}
