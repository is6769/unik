package algorithms.practice4.JSONParser;

public enum States {
    START,

    /**
     * Character {
     */
    OPENINGBRACE,

    /**
     * Character }
     */
    CLOSINGBRACE,

    /**
     * Character [
     */
    OPENINGBRACKET,

    /**
     * Character ]
     */
    CLOSINGBRACKET,
    OPENINGQUOTE,
    CLOSINGQUOTE,
    COLON,
    ESCAPECHARACTER,
    COMMA,
}
