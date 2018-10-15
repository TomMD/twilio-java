/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.twiml.TwiML;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Pay>}
 */
public class Pay extends TwiML {
    public enum Input {
        DTMF("dtmf");

        private final String value;

        private Input(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum StatusCallbackMethod {
        GET("GET"),
        POST("POST");

        private final String value;

        private StatusCallbackMethod(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum TokenType {
        ONE_TIME("one-time"),
        REUSABLE("reusable");

        private final String value;

        private TokenType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum Currency {
        USD("usd"),
        EUR("eur"),
        GBP("gbp");

        private final String value;

        private Currency(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum ValidCardTypes {
        VISA("visa"),
        MASTER_CARD("master-card"),
        AMEX("amex"),
        MAESTRO("maestro"),
        DISCOVER("discover"),
        OPTIMA("optima"),
        JCB("jcb"),
        DINERS_CLUB("diners-club"),
        ENROUTE("enroute");

        private final String value;

        private ValidCardTypes(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    public enum Language {
        DE_DE("de-DE"),
        EN_AU("en-AU"),
        EN_CA("en-CA"),
        EN_GB("en-GB"),
        EN_IN("en-IN"),
        EN_IE("en-IE"),
        EN_NZ("en-NZ"),
        EN_PH("en-PH"),
        EN_ZA("en-ZA"),
        EN_US("en-US"),
        ES_ES("es-ES"),
        ES_US("es-US"),
        FR_CA("fr-CA"),
        FR_FR("fr-FR"),
        IT_IT("it-IT");

        private final String value;

        private Language(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final Pay.Input input;
    private final URI action;
    private final URI statusCallback;
    private final Pay.StatusCallbackMethod statusCallbackMethod;
    private final Integer timeout;
    private final Integer maxAttempts;
    private final Boolean securityCode;
    private final String postalCode;
    private final String paymentConnector;
    private final Pay.TokenType tokenType;
    private final String chargeAmount;
    private final Pay.Currency currency;
    private final String credentialSid;
    private final String description;
    private final List<Pay.ValidCardTypes> validCardTypes;
    private final Pay.Language language;

    /**
     * For XML Serialization/Deserialization
     */
    private Pay() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Pay>} element
     */
    private Pay(Builder b) {
        super("Pay", b);
        this.input = b.input;
        this.action = b.action;
        this.statusCallback = b.statusCallback;
        this.statusCallbackMethod = b.statusCallbackMethod;
        this.timeout = b.timeout;
        this.maxAttempts = b.maxAttempts;
        this.securityCode = b.securityCode;
        this.postalCode = b.postalCode;
        this.paymentConnector = b.paymentConnector;
        this.tokenType = b.tokenType;
        this.chargeAmount = b.chargeAmount;
        this.currency = b.currency;
        this.credentialSid = b.credentialSid;
        this.description = b.description;
        this.validCardTypes = b.validCardTypes;
        this.language = b.language;
    }

    /**
     * Attributes to set on the generated XML element
     * 
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getInput() != null) {
            attrs.put("input", this.getInput().toString());
        }
        if (this.getAction() != null) {
            attrs.put("action", this.getAction().toString());
        }
        if (this.getStatusCallback() != null) {
            attrs.put("statusCallback", this.getStatusCallback().toString());
        }
        if (this.getStatusCallbackMethod() != null) {
            attrs.put("statusCallbackMethod", this.getStatusCallbackMethod().toString());
        }
        if (this.getTimeout() != null) {
            attrs.put("timeout", this.getTimeout().toString());
        }
        if (this.getMaxAttempts() != null) {
            attrs.put("maxAttempts", this.getMaxAttempts().toString());
        }
        if (this.isSecurityCode() != null) {
            attrs.put("securityCode", this.isSecurityCode().toString());
        }
        if (this.getPostalCode() != null) {
            attrs.put("postalCode", this.getPostalCode());
        }
        if (this.getPaymentConnector() != null) {
            attrs.put("paymentConnector", this.getPaymentConnector());
        }
        if (this.getTokenType() != null) {
            attrs.put("tokenType", this.getTokenType().toString());
        }
        if (this.getChargeAmount() != null) {
            attrs.put("chargeAmount", this.getChargeAmount());
        }
        if (this.getCurrency() != null) {
            attrs.put("currency", this.getCurrency().toString());
        }
        if (this.getCredentialSid() != null) {
            attrs.put("credentialSid", this.getCredentialSid());
        }
        if (this.getDescription() != null) {
            attrs.put("description", this.getDescription());
        }
        if (this.getValidCardTypess() != null) {
            attrs.put("validCardTypes", this.getValidCardTypessAsString());
        }
        if (this.getLanguage() != null) {
            attrs.put("language", this.getLanguage().toString());
        }

        return attrs;
    }

    /**
     * Input type Twilio should accept
     * 
     * @return Input type Twilio should accept
     */
    public Pay.Input getInput() {
        return input;
    }

    /**
     * Action URL
     * 
     * @return Action URL
     */
    public URI getAction() {
        return action;
    }

    /**
     * Status callback URL
     * 
     * @return Status callback URL
     */
    public URI getStatusCallback() {
        return statusCallback;
    }

    /**
     * Status callback method
     * 
     * @return Status callback method
     */
    public Pay.StatusCallbackMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    /**
     * Time to wait to gather input
     * 
     * @return Time to wait to gather input
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Maximum number of allowed retries when gathering input
     * 
     * @return Maximum number of allowed retries when gathering input
     */
    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Prompt for security code
     * 
     * @return Prompt for security code
     */
    public Boolean isSecurityCode() {
        return securityCode;
    }

    /**
     * Prompt for postal code and it should be true/false or default postal code
     * 
     * @return Prompt for postal code and it should be true/false or default postal
     *         code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Unique name for payment connector
     * 
     * @return Unique name for payment connector
     */
    public String getPaymentConnector() {
        return paymentConnector;
    }

    /**
     * Type of token
     * 
     * @return Type of token
     */
    public Pay.TokenType getTokenType() {
        return tokenType;
    }

    /**
     * Amount to process. If value is greater than 0 then make the payment else
     * create a payment token
     * 
     * @return Amount to process. If value is greater than 0 then make the payment
     *         else create a payment token
     */
    public String getChargeAmount() {
        return chargeAmount;
    }

    /**
     * Currency of the amount attribute
     * 
     * @return Currency of the amount attribute
     */
    public Pay.Currency getCurrency() {
        return currency;
    }

    /**
     * SID for API keys to communicate with payment provider
     * 
     * @return SID for API keys to communicate with payment provider
     */
    public String getCredentialSid() {
        return credentialSid;
    }

    /**
     * Details regarding the payment
     * 
     * @return Details regarding the payment
     */
    public String getDescription() {
        return description;
    }

    /**
     * Comma separated accepted card types
     * 
     * @return Comma separated accepted card types
     */
    public List<Pay.ValidCardTypes> getValidCardTypess() {
        return validCardTypes;
    }

    protected String getValidCardTypessAsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Pay.ValidCardTypes> iter = this.getValidCardTypess().iterator();
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            if (iter.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Language to use
     * 
     * @return Language to use
     */
    public Pay.Language getLanguage() {
        return language;
    }

    /**
     * Create a new {@code <Pay>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private Pay.Input input;
        private URI action;
        private URI statusCallback;
        private Pay.StatusCallbackMethod statusCallbackMethod;
        private Integer timeout;
        private Integer maxAttempts;
        private Boolean securityCode;
        private String postalCode;
        private String paymentConnector;
        private Pay.TokenType tokenType;
        private String chargeAmount;
        private Pay.Currency currency;
        private String credentialSid;
        private String description;
        private List<Pay.ValidCardTypes> validCardTypes;
        private Pay.Language language;

        /**
         * Input type Twilio should accept
         */
        public Builder input(Pay.Input input) {
            this.input = input;
            return this;
        }

        /**
         * Action URL
         */
        public Builder action(URI action) {
            this.action = action;
            return this;
        }

        /**
         * Action URL
         */
        public Builder action(String action) {
            this.action = Promoter.uriFromString(action);
            return this;
        }

        /**
         * Status callback URL
         */
        public Builder statusCallback(URI statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        /**
         * Status callback URL
         */
        public Builder statusCallback(String statusCallback) {
            this.statusCallback = Promoter.uriFromString(statusCallback);
            return this;
        }

        /**
         * Status callback method
         */
        public Builder statusCallbackMethod(Pay.StatusCallbackMethod statusCallbackMethod) {
            this.statusCallbackMethod = statusCallbackMethod;
            return this;
        }

        /**
         * Time to wait to gather input
         */
        public Builder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Maximum number of allowed retries when gathering input
         */
        public Builder maxAttempts(Integer maxAttempts) {
            this.maxAttempts = maxAttempts;
            return this;
        }

        /**
         * Prompt for security code
         */
        public Builder securityCode(Boolean securityCode) {
            this.securityCode = securityCode;
            return this;
        }

        /**
         * Prompt for postal code and it should be true/false or default postal code
         */
        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * Unique name for payment connector
         */
        public Builder paymentConnector(String paymentConnector) {
            this.paymentConnector = paymentConnector;
            return this;
        }

        /**
         * Type of token
         */
        public Builder tokenType(Pay.TokenType tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        /**
         * Amount to process. If value is greater than 0 then make the payment else
         * create a payment token
         */
        public Builder chargeAmount(String chargeAmount) {
            this.chargeAmount = chargeAmount;
            return this;
        }

        /**
         * Currency of the amount attribute
         */
        public Builder currency(Pay.Currency currency) {
            this.currency = currency;
            return this;
        }

        /**
         * SID for API keys to communicate with payment provider
         */
        public Builder credentialSid(String credentialSid) {
            this.credentialSid = credentialSid;
            return this;
        }

        /**
         * Details regarding the payment
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Comma separated accepted card types
         */
        public Builder validCardTypes(List<Pay.ValidCardTypes> validCardTypes) {
            this.validCardTypes = validCardTypes;
            return this;
        }

        /**
         * Comma separated accepted card types
         */
        public Builder validCardTypes(Pay.ValidCardTypes validCardTypes) {
            this.validCardTypes = Promoter.listOfOne(validCardTypes);
            return this;
        }

        /**
         * Language to use
         */
        public Builder language(Pay.Language language) {
            this.language = language;
            return this;
        }

        /**
         * Add a child {@code <Prompt>} element
         */
        public Builder prompt(Prompt prompt) {
            this.children.add(prompt);
            return this;
        }

        /**
         * Create and return resulting {@code <Pay>} element
         */
        public Pay build() {
            return new Pay(this);
        }
    }
}