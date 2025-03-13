package org.liquibase.ext.licensecheck.command;

import liquibase.license.LicenseServiceUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockStatic;

class LicenseCheckCommandStepTest {

    private LicenseCheckCommandStep licenseCheckCommandStep;

    @BeforeEach
    void setUp() {
        licenseCheckCommandStep = new LicenseCheckCommandStep();
    }

    @Test
    void run_validLicense_doesNotThrowException() throws Exception {
        try (MockedStatic<LicenseServiceUtils> licenseServiceUtilsMock = mockStatic(LicenseServiceUtils.class)) {
            licenseServiceUtilsMock.when(LicenseServiceUtils::isProLicenseValid).thenReturn(Boolean.TRUE);
            licenseCheckCommandStep.run(null);
        }
    }

    @Test
    void run_invalidLicense_throwsException() {
        try (MockedStatic<LicenseServiceUtils> licenseServiceUtilsMock = mockStatic(LicenseServiceUtils.class)) {
            licenseServiceUtilsMock.when(() -> LicenseServiceUtils.checkProLicenseAndThrowException(LicenseCheckCommandStep.COMMAND_NAME)).thenThrow(new RuntimeException("Invalid license"));
            assertThrows(RuntimeException.class, () -> licenseCheckCommandStep.run(null));
        }
    }
}