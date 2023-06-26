package pl.adreszler.productapp;

enum Category {
    GROCERY("art. spożywcze"),
    HOUSEHOLD("art. gospodarstwa domowego"),
    DIFFERENT("inne");

    private final String namePl;

    Category(String namePl) {
        this.namePl = namePl;
    }

    public String getNamePl() {
        return namePl;
    }
}
