
package org.cst8288Lab2.utility;


public enum TermType {
    WINTER(1),
    SUMMER(2),
    FALL(3);

    final int term;

    /**
     * Constructs a TermType enum with the specified number.
     *
     * @param term The integer value associated with the term number.
     */
    TermType(int term) {
        this.term = term;
    }

    public int getTerm() {
        return term;
    }

    public static int mapTerm(String termStr)  {
        switch (termStr.toUpperCase()) {
            case "WINTER":
                return TermType.WINTER.term;
            case "SUMMER":
                return TermType.SUMMER.term;
            case "FALL":
                return TermType.FALL.term;
            default:
                return 0;  //not map
        }
    }
}
