public class CustomDouble implements CustomAdder<Double>{

    private Double value;

    public CustomDouble(Double value) {
        this.value = value;
    }

    @Override
    public Double add(Double d1) {
        return value + d1;
    }
}
