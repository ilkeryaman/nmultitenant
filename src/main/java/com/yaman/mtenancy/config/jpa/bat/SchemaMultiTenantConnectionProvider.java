package com.yaman.mtenancy.config.jpa.bat;

import com.yaman.mtenancy.entity.tenancy.Tenant;
import com.yaman.mtenancy.service.tenancy.TenantService;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SchemaMultiTenantConnectionProvider implements MultiTenantConnectionProvider<String> {

    private final TenantService tenantService;
    private final Map<String, DataSource> dataSourceCache = new ConcurrentHashMap<>();

    public SchemaMultiTenantConnectionProvider(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    private DataSource getDataSource(String tenantIdentifier) {
        return dataSourceCache.computeIfAbsent(tenantIdentifier, tenantId -> {
            Tenant tenant = tenantService.getTenant(tenantId);
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(tenant.getJdbcUrl());
            config.setUsername(tenant.getUsername());
            config.setPassword(tenant.getPassword());
            return new HikariDataSource(config);
        });
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return getConnection(SchemaTenantIdentifierResolver.DEFAULT_TENANT);
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        DataSource dataSource = getDataSource(tenantIdentifier);
        return dataSource.getConnection();
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return true;
    }

    @Override
    @org.checkerframework.checker.nullness.qual.UnknownKeyFor
    @org.checkerframework.checker.nullness.qual.NonNull
    @org.checkerframework.checker.initialization.qual.Initialized
    public boolean isUnwrappableAs(@org.checkerframework.checker.nullness.qual.UnknownKeyFor @org.checkerframework.checker.nullness.qual.NonNull @org.checkerframework.checker.initialization.qual.Initialized Class<@org.checkerframework.checker.nullness.qual.UnknownKeyFor @org.checkerframework.checker.nullness.qual.NonNull @org.checkerframework.checker.initialization.qual.Initialized ?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(@org.checkerframework.checker.nullness.qual.UnknownKeyFor @org.checkerframework.checker.nullness.qual.NonNull @org.checkerframework.checker.initialization.qual.Initialized Class<T> aClass) {
        return null;
    }
}
