/*
 * Attribution
 * CC BY
 * This license lets others distribute, remix, tweak,
 * and build upon your work, even commercially,
 * as long as they credit you for the original creation.
 * This is the most accommodating of licenses offered.
 * Recommended for maximum dissemination and use of licensed materials.
 *
 * http://creativecommons.org/licenses/by/3.0/
 * http://creativecommons.org/licenses/by/3.0/legalcode
 */
package com.thjug.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author @nuboat
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
	@NamedQuery(name = Account.COUNT_ALL, query = "SELECT COUNT(a) FROM Account a"),
	@NamedQuery(name = Account.FIND_BY_USERNAME, query = "SELECT a FROM Account a WHERE UPPER(a.username) = ?1"),})
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String COUNT_ALL = "Account.countAll";
	public static final String FIND_BY_USERNAME = "Account.findByUsername";

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "account_seq_gen", sequenceName = "account_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq_gen")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Column(name = "typeid")
	private char typeid;
	@Basic(optional = false)
	@NotNull
	@Column(name = "enableid")
	private char enableid;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "username")
	private String username;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "passwd")
	private String passwd;
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "email")
	private String email;
	@Size(max = 64)
	@Column(name = "firstname")
	private String firstname;
	@Size(max = 64)
	@Column(name = "lastname")
	private String lastname;
	@Size(max = 32)
	@Column(name = "twitter")
	private String twitter;
	@Size(max = 128)
	@Column(name = "bio")
	private String bio;
	@Size(max = 256)
	@Column(name = "avatarpath")
	private String avatarpath;
	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	@Column(name = "updateby")
	private Integer updateby;

	public Account() {
	}

	public Account(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public char getTypeid() {
		return typeid;
	}

	public void setTypeid(final char typeid) {
		this.typeid = typeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(final String twitter) {
		this.twitter = twitter;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(final String bio) {
		this.bio = bio;
	}

	public String getAvatarpath() {
		return avatarpath;
	}

	public void setAvatarpath(final String avatarpath) {
		this.avatarpath = avatarpath;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(final Date updated) {
		this.updated = updated;
	}

	public Integer getUpdateby() {
		return updateby;
	}

	public void setUpdateby(final Integer updateby) {
		this.updateby = updateby;
	}

	public char getEnableid() {
		return enableid;
	}

	public void setEnableid(final char enableid) {
		this.enableid = enableid;
	}

	@Override
	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

	@Override
	public boolean equals(final Object object) {
		// Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Account)) {
			return false;
		}
		final Account other = (Account) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Account[ id=" + id + " ]";
	}

}
