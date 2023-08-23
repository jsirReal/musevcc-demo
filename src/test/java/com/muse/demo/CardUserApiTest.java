package com.muse.demo;

import com.muse.demo.dto.Document;
import com.muse.demo.dto.Individual;
import org.junit.jupiter.api.Test;


public class CardUserApiTest {

    /**
     * private key, please keep it in a safe place
     */
    public static String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCP0P0KDjcHuI+Bhzebw/JDV1ZclAZbbAxtv9VFqhZ4dCbxd00tZoMgi8EI7m7LF4VJSeY/XeHsWjCflVyGYRfVJ2eCa+o0ModP2EJlZnVHFTjfKg1az3QILw60LhcAxcCi+UD7nax6CMZQgCsgsbwaDe+YrIgGE7eg/ti6JU8hi7i6m3GwqXc9+qH6MGoCwohxv1erg3wrK9vuDC9kBSKWvnolr0cgIsV5mxSgkmJoJdIbPbDVlTehFCfPnsO5xsThWfw5kPQIxtqkm7i762eUT1TsUqYJFabhgNKKsJsljSEo0lEDy9vwsGxXBj+XFRRdOTozUHHT+jKYnTRPACv/AgMBAAECggEAEzQVxbT2Niq3xtT2YO8+Ny2/U2dUnfqEglceNEos6/KejJmgjZJlqf/fS8ECvE2st4eNniJ8G2JDoduA2lS2qPi1Ap5ETKn+lXPMEdwnhtFXobzswZZ36OvXq8mHusutGFXuDmsUb8siJ/elSp1Q/62is6E+HImfeHjvGZQHx/O7+MdvbYNNn5EchomxDiRa8iHiF9Nrc56Vckjk3XcuCDH3eZMRghiWbii3IzYzG9ETEpK8S1gWKaYUWZGSIKvHz3k4W05/+WF98w72B4S78xjxa8SuRJgoeE5U0qoJ1UrX5CvaOOWuuGknwhzstEuMWNhZ6V/GdwZR9lz9l/p4sQKBgQDFR8t1+8ncM1Aa5jjcI+/CoW9bdf17VJBWyXAP/sJyHC6XtaP0yT7GQrjC8t7PPtPwBQnmnSD6ZTKbI0+Br9Dj4jsimnaL0EfJyDlcu6j7etCoOQSVDlw8w1T4RE3J+mqrBHNNEcxLUNVArPBPWpwN8lb7R1PKIULrg9acm7c9+QKBgQC6n2IhEK4ENn7+y3hA6JUD7z0cIivzs8Pjbo2yNbjFvDyjSsnKa+RcoRIy59kgmmFkEliuzrDAH4br2JKq6B3TU94sxk60ZqypsiTz/V7I5cb5jv99U9GigW9s1iwoCugJSctUqfLwQJwBtOO+hxADr3aoTVLP7Y02CRNbFl2XtwKBgQDCrfvBHUzxaQ22zdP0od37glWiuwf+yc96ZWSZ1DzMYLU17wCyElpJShSMBSINACIjbMV9dzfRAUZ0Q980ymxoRZs3pZgwlsQRAu5gbavvJx57s3CrKzWonNXf/X+KPv0+cLDbsCGbfVREc6Tdmjv/o1Nkutmb0UD5quuBNkUY+QKBgDr/E9h8G2b9i1wlGpj6bdFWmi0AqIBcPfryAh1qWkU4YrsEc5JoVULrMIOjQ8LIyy0Fl797W+kAjniUeJlK09Lw2nWxI0RoiQEEbiYr3QEJksNl72LBUq5a2MzBUChAemYlTAAx0bkd07O+aZjbvbZMi+hcuWc+I7wHVnUfNus1AoGAPrtLMEom1lTCFiboxirHMHCQOYJPPSZxGuYjwJ7WC++GeEt3SSEDPE470dw3lecJ6cmpQOQla5hppqUMAVefgyDuxwl+eo0b8PqFtehvRh5ME9aPQFZJbD5i1vyADbPs1OF6UwlfsFP6bSdVBg9bW6MBihB5eDu4Dn6P+gLN6D4=";
    /**
     * platform public key, please download from musepay partner dashboard
     */
    public static String platformKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlzLOiHRaKpPkOnBVtCUQnFVKyKn0BNNjc4NUPAXE/jrcE/mnO6uBBEpj6Xp3yCTqCU0yL1EhLZqyvEldPahVNVhAVet2joh6LLePd7wGMf96Il+Oh8g/lj9XNfKjqRm6ed0H5j+DeV0//tMOyU0f07PjxGTVCC//EcYLLLjR/bq5LVoczypGELWaRFYRbN8bZqs2/uJ8x46mFdK+vmMYtswCdGm9xQwOB9Q4l2M/zXh4pOZqdWfmgpvhUhHjG2/PcmYT4a3R3NTFhjc4RU8LRjaoxLGdHX6qWLBZhUrsCREYKfRSA+7L0ME8Y16wySH8yqb/QuC+H7d7AbLraUBf/wIDAQAB";

    private final String baseUrl = "https://api.dev01.musepay.io/v1/";

    private final MuseClient client = MuseClient.build(baseUrl, privateKey, platformKey);


    @Test
    public void cardUserCreate() {

        Individual individual = new Individual();
        individual.setLast_name("jack2");
        individual.setFirst_name("micky2");
        individual.setDate_of_birth("1982-10-10");
        individual.setOccupation("aaa");
        individual.setAnnual_income("100000");


        Document document = new Document();
        document.setType("1");
        document.setFront("data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAZAAAAGQAQAAAACoxAthAAAEMElEQVR42u1cS27lMAyTVzlGbprk3TTHyCqeiKTy60OB2c1Aeihe3cD0QrAkUlJq/a8/VpCCFKQgBfmnIJsdn9b7fvwa1rn3z2bTcHyPu437seirDX3xXWNBAPGFNti4HM83m7tj/XlfDziA2lmQY3Fs+7iRj2/sPCDxcKF53ebWCnKHHFcRt+5u1Y9bW08K8s3I7siTw0caduefHScU5O3IHu7k0cPaOozMK3qtC3JLFpvb9pefL/klLUSf1ZBMd08WCHpcbIqK3zhMVogb2W04YY8vhhUUxb14hzu7g/tPQWjklRHPsaJwYCZucEMk9GzbafaCIKB9YGdAOjfsjtU5pMFGFleQ08jQBVAEq5tUOVcCgU8KckJmxTpPGXJk6im4cwMQZi/ISUh0CUVFtjGUFBwZZ/ZIGQXBftzJEAXhyB3i3RfgwH5aQSQTPFnQnj3U6JEvDv/1nRaOvAwFESGh0nwQElzLRYf05QeHSQ3x4OZi80ZIcAi8e0bFgza/yYTsEIvS0BXxQEgaLyeJ8YuQZIaAv9FtoxDkC1YjY/EkJNkhHvqoFFjWhsPirj6KbA9CkhtikyLbkVjtLqz6WcsNGlwQO4tmICGT8155LoLe2r5rsdyQHtUM7Ddo9sPaTRHPZcKbkKSHNN+w2iWsUOLmIe7Ffqa9CElmiJM3+rLiGwiJn0DXppxXL68gas8xwwYtQU2yietGz84eGTk5JASCp1dUP7Afh7BxMNmbw6SGUEBh20dXlOU1f76QnEDa33w/OcSfRD5lL3jkd0fcaz8JSXaIlIK6Tgx3pjw7ScU/HTk7hGaU8/au1vlicm149JvCpYbAeRsMO0eBaGabAClDDfS7I2eHxGTLvWE3rFT0TK+7bulYkHNUA5eQ3eGRCZeVNEY/1I4ehe7cEANto5iKWSl3Z5SM1GH/ol7zQtiwU9FM6qDRvBb1200Ft4KcrQFPCgPpxzVDRc9d1FV5DLfkhkQREsVtpQzYtkUJN8ZEC3LJhA5CsqsjALEgLPvFVKYFCcigkYzb4MGq6HcNb9jcCyKIeuW6mZpyYTGNworlo7uwSg4heZuGaGiigdJCjZ6J9a3FUkMuR8bNHBfqKVxICquXI+eGrJrHQFN40fCnXgE4u8OfhyNnh5z1/7lHOeiSnwx9IC2PWYXEEHHd8SRsrZOZjD16nZxGuGux3BAzNdDZypTzUrPLr8+6R0FisJ9TsjFApRe+llOBsnxUkPtLExsVuhp2UZAkwaNTj/vrNZO0EL2Yo17wlWRDn0K5q9tSkOvlL5XOlCyuae1BMfA1QJUcEg07MZMpYh0m9PyQ9nLkghhf8nq9CyBaoubmFyMnh5jmMWKumNNTLWYd3yW13JB+DpXRklsYmYOgMdzyKcgzWQR5s3MuaIkBqrm/B6hSQ+p/qhSkIAUpyH8L+QM8qRjL2c9mRwAAAABJRU5ErkJggg==");
        document.setBack("");
        document.setNumber("123");
        document.setCountry("CN");
        document.setExpiry_date("2035-10-10");


        String respStr = client.cardUserCreate("abc-1",
                "abc-2@1234.com",
                "2000601",
                "2",
                individual,
                document
        );
        System.out.println(respStr);
    }

    @Test
    public void cardUserQuery() {

        Individual individual = new Individual();
        Document document = new Document();
        String respStr = client.cardUserQuery("",
                "",
                "2000601",
                "2",
                ""
        );
        System.out.println(respStr);
    }
}
