package org.liquibase.ext.licensecheck.command;

import liquibase.Scope;
import liquibase.command.AbstractCommandStep;
import liquibase.command.CommandResultsBuilder;
import liquibase.license.LicenseServiceUtils;

public class LicenseCheckCommandStep extends AbstractCommandStep {

    protected static final String[] COMMAND_NAME = new String[]{"licenseCheck"};

    @Override
    public String[][] defineCommandNames() {
        return new String[][]{COMMAND_NAME};
    }

    @Override
    public void run(CommandResultsBuilder resultsBuilder) throws Exception {
        Scope.getCurrentScope().getLog(LicenseCheckCommandStep.class).info("Checking pro license...");
        LicenseServiceUtils.checkProLicenseAndThrowException(COMMAND_NAME);
        Scope.getCurrentScope().getLog(LicenseCheckCommandStep.class).info("Pro license is valid!");
    }
}
