package com.saucedemo.utils;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.model.environment.UndefinedEnvironmentVariableException;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

/**
 * The purpose of this class is to provide access to a singleton instances of {@link EnvironmentVariables}
 * and {@link EnvironmentSpecificConfiguration}.
 */
public class Environment {

    private static EnvironmentVariables ENVIRONMENT_VARIABLES_INSTANCE;
    private static EnvironmentSpecificConfiguration ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE;

    private Environment() {
    }

    /**
     * Used for retrieving the system environment variables, including variables passed in from:<br>
     * <ul>
     *     <li>Command Line</li>
     *     <li>serenity.conf file</li>
     * </ul>
     *
     * @return Instance of {@link EnvironmentVariables}
     */
    public static EnvironmentVariables getSystemEnvironmentVariables() {
        if(ENVIRONMENT_VARIABLES_INSTANCE == null) {
            ENVIRONMENT_VARIABLES_INSTANCE = SystemEnvironmentVariables.createEnvironmentVariables();
        }

        return ENVIRONMENT_VARIABLES_INSTANCE;
    }

    /**
     * Checks for presence of property in system environment variables.
     *
     * @param propertyName Name of property to verify presence of.
     * @return boolean value based on whether property is found.
     */
    public static boolean systemEnvironmentVariablesHasProperty(String propertyName) {
        try {
            return getSystemEnvironmentVariables().getProperty(propertyName) != null;
        }
        catch (UndefinedEnvironmentVariableException e) {
            return false;
        }
    }

    /**
     * Used for retrieving environment specific configurations defined under environments in the serenity.conf file.
     *
     * @return Instance of {@link EnvironmentSpecificConfiguration}
     */
    public static EnvironmentSpecificConfiguration getEnvironmentSpecificConfiguration() {
        if(ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE == null) {
            ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE = EnvironmentSpecificConfiguration.from(getSystemEnvironmentVariables());
        }

        return ENVIRONMENT_SPECIFIC_CONFIGURATION_INSTANCE;
    }

    /**
     * Checks for presence of property in environment specific configuration.
     *
     * @param propertyName Name of property to verify presence of.
     * @return boolean value based on whether property is found.
     */
    public static boolean environmentSpecificConfigurationHasProperty(String propertyName) {
        try {
            return getEnvironmentSpecificConfiguration().getProperty(propertyName) != null;
        }
        catch (UndefinedEnvironmentVariableException e) {
            return false;
        }
    }
}
