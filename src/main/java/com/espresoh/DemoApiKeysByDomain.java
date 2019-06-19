package com.espresoh;

public enum DemoApiKeysByDomain {
    BUSINESS("yyzo1t0bm53r0u89bdzq5khu"),
    SOCIAL("1txg3mxe6rkp1rrxc3homy1d"),
    CONTACT("5c1i7x2suymeg62iwa3kup60");

    private final String apiKey;

    DemoApiKeysByDomain(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
