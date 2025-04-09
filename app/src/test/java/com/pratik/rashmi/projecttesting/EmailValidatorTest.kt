package com.pratik.rashmi.projecttesting

import org.junit.Assert
import org.junit.Test


class EmailValidatorTest {

    @Test
    fun givenBasicEmailFormat_whenValidated_thenReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun givenSubdomainEmailFormat_whenValidated_thenReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun givenEmailMissingDomain_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun givenEmailWithDoubleDots_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }

    @Test
    fun givenEmailMissingUsername_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }

    @Test
    fun givenEmailWithoutAtSymbol_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun givenEmptyEmailString_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun givenNullEmailInput_whenValidated_thenReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }
}