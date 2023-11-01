public class CustomInteger implements CustomAdder<Integer> {

    private Integer value;

    public CustomInteger(Integer value) {
        this.value = value;
    }

    @Override
    public Integer add(Integer t1) {
        Integer sum =  value + t1;
        return sum;
    }
}
