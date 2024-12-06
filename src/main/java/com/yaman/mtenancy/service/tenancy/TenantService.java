package com.yaman.mtenancy.service.tenancy;

import com.yaman.mtenancy.entity.tenancy.Tenant;
import com.yaman.mtenancy.exception.TenantNotFoundException;

public interface TenantService {
    Tenant getTenant(String tenantId) throws TenantNotFoundException;
}
