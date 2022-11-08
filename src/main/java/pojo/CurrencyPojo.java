package pojo;

public class CurrencyPojo {
    private Integer r030;
    private String txt;
    private Double rate;
    private String cc;
    private String exchangedate;

    @Override
    public String toString() {
        return "CurrencyPojo{" +
                "rate=" + rate +
                ", cc='" + cc + '\'' +
                '}';
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    public Double getRate() {
        return rate;
    }

    public String getCc() {
        return cc;
    }

    public Integer getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public String getExchangedate() {
        return exchangedate;
    }
}
