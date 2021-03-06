package com.sap.cloudfoundry.client.facade.adapters;

import com.sap.cloudfoundry.client.facade.domain.Derivable;
import org.cloudfoundry.client.v3.roles.RoleResource;
import org.immutables.value.Value;

import com.sap.cloudfoundry.client.facade.domain.UserRole;

@Value.Immutable
public abstract class RawUserRole implements Derivable<UserRole> {

    @Value.Parameter
    public abstract RoleResource getRoleResource();

    @Override
    public UserRole derive() {
        RoleResource role = getRoleResource();
        return UserRole.fromRoleType(role.getType());
    }

}
