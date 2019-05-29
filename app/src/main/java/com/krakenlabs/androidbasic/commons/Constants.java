package com.krakenlabs.androidbasic.commons;

/**
 * Created by Alan Giovani Cruz Méndez on 2019-05-29 12:24.
 * cruzmendezalan@gmail.com
 */
public class Constants {
    public enum RulesText {
        MAIL                           { public String toString() { return "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";}},
        NUMBER                         { public String toString() { return "^[0-9]{0,25}$";}},
        NUMBERADDRESS_INNER            { public String toString() { return "^[A-Za-z0-9ñÑÁáÉéÍíÓóÚú #.-]{0,50}$";}},
        NUMBERADDRESS                  { public String toString() { return "^[A-Za-z0-9 ]{0,20}$";}},
        NAME                           { public String toString() { return "^[A-Za-z-ñÑÁáÉéÍíÓóÚú ]{4,100}$";}},
        STRING                         { public String toString() { return "^[A-Za-z-.ñÑÁáÉéÍíÓóÚú ]{0,100}$";}},
        ALFANUMERIC                    { public String toString() { return "^[A-Z0-9a-z-.ñÑÁáÉéÍíÓóÚú ]{0,100}$";}},
        ALFANUMERIC_AND_SPECIALS_SPACE { public String toString() { return "^[A-Z0-9a-zñÑÁáÉéÍíÓóÚú\\_ ]{0,100}$";}},
        PASS                           { public String toString() { return "^[a-zA-Z0-9_ #=!?¿¡,ÑñÁÉÍÓÚáéíóú./()*-@]{8,40}$";}},
        RFC                            { public String toString() { return "^[a-zA-Z&]{4}(\\d{6})([A-Z0-9a-z]{3})?$";}},
        RFCM                           { public String toString() { return "^([A-ZÑ\\x26]{3,4}([0-9]{2})(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))((-)?([A-Z\\d]{3}))?$";}},
        WORD                           { public String toString() { return "\"([\\w]+)\"";}},
        LENGHT_MIN                     { public String toString() { return "LENGHT_MIN";}},
        LENGHT_MIN_PASSWORD            { public String toString() { return "LENGHT_MIN_PASSWORD";}},
        ALFANUMERIC_AND_SPECIALS       { public String toString() { return "^[a-zA-Z0-9\\-\\+\\*\\#\\.\\&]*";}},
        EMPTY_STRING                   { public String toString() { return "^$";}},
        PHONENUMBER                    { public String toString() { return "^[0-9]{10}$";}},
        LENGHT_ASSOCIATE_NUMBER        { public String toString() { return "^[0-9]{7}$";}},
        VALID_ZIPCODE                  { public String toString() { return "^[0-9]{5}";}},
        BIRTHDATE                      { public String toString() { return "^[0-9]{2}/[0-9]{2}/[0-9]{4}";}};

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
