package com.yaman.mtenancy.config.jpa.bat;

import com.yaman.mtenancy.context.TenantContext;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

public class SchemaTenantIdentifierResolver implements CurrentTenantIdentifierResolver<String> {

    public static final String DEFAULT_TENANT = "bat";

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        return tenantId != null ? tenantId : DEFAULT_TENANT;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
