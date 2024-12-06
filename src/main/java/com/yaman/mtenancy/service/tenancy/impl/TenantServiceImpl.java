package com.yaman.mtenancy.service.tenancy.impl;

import com.yaman.mtenancy.entity.tenancy.Tenant;
import com.yaman.mtenancy.exception.TenantNotFoundException;
import com.yaman.mtenancy.repository.tenancy.TenantRepository;
import com.yaman.mtenancy.service.tenancy.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    private final Map<String, Tenant> tenantCache = new HashMap<>();

    @Override
    public Tenant getTenant(String tenantId) throws TenantNotFoundException {
        return tenantCache.computeIfAbsent(tenantId, (tId) -> tenantRepository.findByTenantId(tId).orElseThrow(TenantNotFoundException::new));
    }
}
