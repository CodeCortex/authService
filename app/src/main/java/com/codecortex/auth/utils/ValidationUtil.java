package com.codecortex.auth.utils;

import com.codecortex.auth.model.UserInfoDto;

import java.util.regex.Pattern;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void validateUserAttributes(UserInfoDto userInfoDto) {

        if (userInfoDto == null) {
            throw new IllegalArgumentException(
                    "User information cannot be null"
            );
        }

        // Username
        if (isBlank(userInfoDto.getUsername())) {
            throw new IllegalArgumentException(
                    "Username is required"
            );
        }

        if (userInfoDto.getUsername().trim().length() < 3) {
            throw new IllegalArgumentException(
                    "Username must contain at least 3 characters"
            );
        }

        if (userInfoDto.getUsername().trim().length() > 50) {
            throw new IllegalArgumentException(
                    "Username cannot exceed 50 characters"
            );
        }

        // Password
        if (isBlank(userInfoDto.getPassword())) {
            throw new IllegalArgumentException(
                    "Password is required"
            );
        }

        if (userInfoDto.getPassword().length() < 8) {
            throw new IllegalArgumentException(
                    "Password must contain at least 8 characters"
            );
        }

        // First name
        if (isBlank(userInfoDto.getFirstName())) {
            throw new IllegalArgumentException(
                    "First name is required"
            );
        }

        // Last name
        if (isBlank(userInfoDto.getLastName())) {
            throw new IllegalArgumentException(
                    "Last name is required"
            );
        }

        // Phone
        if (userInfoDto.getPhoneNumber() == null) {
            throw new IllegalArgumentException(
                    "Phone number is required"
            );
        }

        String phone =
                String.valueOf(userInfoDto.getPhoneNumber());

        if (!phone.matches("^[6-9][0-9]{9}$")) {
            throw new IllegalArgumentException(
                    "Invalid phone number"
            );
        }

        // Email
        if (isBlank(userInfoDto.getEmail())) {
            throw new IllegalArgumentException(
                    "Email is required"
            );
        }

        if (!EMAIL_PATTERN.matcher(
                userInfoDto.getEmail().trim()
        ).matches()) {

            throw new IllegalArgumentException(
                    "Invalid email address"
            );
        }
    }

    private static boolean isBlank(String value) {
        return value == null ||
                value.trim().isEmpty();
    }
}