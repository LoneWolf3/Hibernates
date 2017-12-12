package com.sac.mapping;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

/**
 * A type that maps between {@link java.sql.Types#VARCHAR CHAR(1) or CHAR(2)}
 * and {@link Boolean} (using "J " and "N ").
 * <p>
 * Optionally, a parameter "length" can be set that will result in right-padding
 * with spaces up to the specified length.
 */
public class JeeNeeUserType implements UserType, ParameterizedType {

	public static final String NAME = "jee_nee";

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return Boolean.class;
	}

	@Override
	public boolean equals(final Object x, final Object y) throws HibernateException {
		if (x == null || y == null) {
			return false;
		} else {
			return x.equals(y);
		}
	}

	@Override
	public int hashCode(final Object x) throws HibernateException {
		assert (x != null);
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session,
			final Object owner) throws HibernateException, SQLException {
		final String s = rs.getString(names[0]);

		if ("J".equalsIgnoreCase(s.trim())) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public void nullSafeSet(final PreparedStatement st, final Object value, final int index,
			final SessionImplementor session) throws HibernateException, SQLException {
		String s = Boolean.TRUE.equals(value) ? "Jee" : "Nee";

		st.setString(index, s);
	}

	@Override
	public Object deepCopy(final Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Serializable disassemble(final Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(final Serializable cached, final Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(final Object original, final Object target, final Object owner) throws HibernateException {
		return original;
	}

	@Override
	public void setParameterValues(final Properties parameters) {

	}



}