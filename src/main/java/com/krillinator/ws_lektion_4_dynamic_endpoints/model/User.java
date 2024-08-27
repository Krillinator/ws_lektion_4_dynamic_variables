package com.krillinator.ws_lektion_4_dynamic_endpoints.model;

// Records are FINAL by default
// Generates automatic methods (get/set/hash/equals etc..)
public record User(
        int id,
        String username,
        String password
) {
}
