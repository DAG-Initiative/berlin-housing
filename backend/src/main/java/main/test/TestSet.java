package main.test;

public class TestSet {
    private String type;
    private Properties properties;
    private Geometry geometry;

    public TestSet(String type, Properties properties, Geometry geometry) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    static class Properties {
        private String name;
        private String amenity;
        private String popupContent;

        public Properties(String name, String amenity, String popupContent) {
            this.name = name;
            this.amenity = amenity;
            this.popupContent = popupContent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAmenity() {
            return amenity;
        }

        public void setAmenity(String amenity) {
            this.amenity = amenity;
        }

        public String getPopupContent() {
            return popupContent;
        }

        public void setPopupContent(String popupContent) {
            this.popupContent = popupContent;
        }
    }

    static class Geometry {
        private String type;
        private double[] coordinates;

        public Geometry(String type, double[] coordinates) {
            this.type = type;
            this.coordinates = coordinates;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(double[] coordinates) {
            this.coordinates = coordinates;
        }
    }

    public static TestSet buildTestSet() {
        return new TestSet("Feature",
                new Properties("Siegessäule", "Landmark", "Tolles Teil"),
                new Geometry("Point", new double[]{52.5148623,13.3483071}));
    }
}


