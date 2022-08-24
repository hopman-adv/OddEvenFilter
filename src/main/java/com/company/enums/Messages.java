package com.company.enums;

/**
 * Enum Messages contains all messages which program can write to console.
 */
public enum Messages {
    EMPTY_LIST("List je prázdný, není co filtrovat. Vypínám program...."),
    INCORRECT_PARAMETERS_COUNT("Jsou podporovány jen jeden nebo dva parametry."),
    SKIPPING_INCORRECT_CHAR("Přeskakuji nepovolený znak: "),
    FILE_NOT_FOUND("Odpovídající soubor nenalezen pod cestou: ."),
    PARSING_FAILED("Parsování String na číslo se nepovedlo pro: "),
    SKIPPING_NEGATIVE("Přeskakuji zápornou hodnotu: "),
    RESULTS_TO_FILE("Hodnoty vypsány do souboru: "),
    WRITING_ERROR_OR_DIRECTORY("Výstupní soubor je poškozen nebo jde o adresář.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
