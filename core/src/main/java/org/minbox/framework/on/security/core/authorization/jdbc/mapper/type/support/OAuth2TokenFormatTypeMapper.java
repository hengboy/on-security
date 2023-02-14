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
import org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat;
import org.springframework.util.ObjectUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * {@link OAuth2TokenFormat}列值转换映射器
 *
 * @author 恒宇少年
 * @since 0.0.8
 */
public class OAuth2TokenFormatTypeMapper implements TypeMapper<OAuth2TokenFormat, String> {
    @Override
    public String toColumn(OAuth2TokenFormat originalValue, String columnName) {
        return originalValue != null ? originalValue.getValue() : null;
    }

    @Override
    public OAuth2TokenFormat fromColumn(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        return !ObjectUtils.isEmpty(columnValue) ? new OAuth2TokenFormat(columnValue) : null;
    }
}
