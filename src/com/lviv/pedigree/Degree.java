package com.lviv.pedigree;

public enum Degree {
    I("Me"),
    MOM("Mom"),
    DAD("Dad"),
    BROTHER("Brother"),
    SISTER("Sister"),
    GRAND_MOTHER_BY_MOM("Grand mother by mom"),
    GRAND_FATHER_BY_MOM("Grand father by mom"),
    GRAND_MOTHER_BY_MOM_SON("Grand mother by mom son"),
    GRAND_MOTHER_BY_DAD("Grand mother by dad son"),
    GRAND_FATHER_BY_DAD("Grand father by dad son"),
    PRA_GRAND_MOTHER_BY_MOM("Pra Grand mother by mom"),
    PRA_GRAND_FATHER_BY_MOM("Pra Grand father by mom"),
    PRA_GRAND_MOTHER_BY_DAD("Pra Grand mother by dad son"),
    PRA_GRAND_FATHER_BY_DAD("Pra Grand father by dad son");

    private String degreeInLowerCase;

    Degree(String degree) {
        degreeInLowerCase = degree;
    }

    Degree() {

    }

    public void printDegreeInSmallLetter() {
        System.out.println(degreeInLowerCase);
    }
}
