/*
 *   Copyright (C) 2022  恒宇少年
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.minbox.framework.on.security.core.authorization.jdbc.mapper.type.support;

import org.minbox.framework.on.security.core.authorization.jdbc.mapper.type.TypeMapper;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * {@link ClientAuthenticationMethod}Set集合列值转换器
 *
 * @author 恒宇少年
 * @since 0.0.8
 */
public class ClientAuthenticationMethodSetTypeMapper implements TypeMapper<Set<ClientAuthenticationMethod>, String> {
    @Override
    public String toColumn(Set<ClientAuthenticationMethod> originalValue, String columnName) {
        return !ObjectUtils.isEmpty(originalValue) ? StringUtils.collectionToCommaDelimitedString(originalValue) : null;
    }

    @Override
    public Set<ClientAuthenticationMethod> fromColumn(ResultSet rs, String columnName) throws SQLException {
        Set<String> clientAuthenticationMethods = StringUtils.commaDelimitedListToSet(rs.getString(columnName));
        if (!ObjectUtils.isEmpty(clientAuthenticationMethods)) {
            return clientAuthenticationMethods.stream().map(method -> new ClientAuthenticationMethod(method))
                    .collect(Collectors.toSet());
        }
        return null;
    }
}
