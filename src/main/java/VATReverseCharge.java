import java.util.ArrayList;

public class VATReverseCharge {

    private class Country {

        private String name;
        private String countryCode;

        public Country(String name, String countryCode) {
            this.name = name;
            this.countryCode = countryCode;
        }

        public String getName() {
            return name;
        }

        public String getCountryCode() {
            return countryCode;
        }
    }

    private static VATReverseCharge singleton;
    private ArrayList<Country> countries;

    private void addCountry(String name, String countryCode) {
        Country country = new Country(name, countryCode);
        countries.add(country);
    }

    private VATReverseCharge() {
        countries = new ArrayList<>();
        addCountry("Frankrijk", "FR");
        addCountry("België", "BE");
        addCountry("Duitsland", "DE");
    }

    public static VATReverseCharge getInstance() {

        if (singleton == null) {
            singleton = new VATReverseCharge();
        }

        return singleton;
    }

    private Country getCountry(String nameOrCode) {

        for (Country country : countries) {

            if (country.getCountryCode().equals(nameOrCode) || country.getName().equals(nameOrCode)) {
                return country;
            }
        }

        return null;
    }

    public boolean isReverseChargeApplicable(String nameOrCode) {
        return this.getCountry(nameOrCode) != null;
    }
}