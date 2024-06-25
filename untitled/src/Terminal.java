public class Terminal {
    private Integer id;
    private String address;
    private Transaction[] transactionArray = new Transaction[10];
    private int transactionIndex = 0;


    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

}
