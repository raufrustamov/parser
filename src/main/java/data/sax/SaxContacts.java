package data.sax;

import java.util.Objects;

public class SaxContacts {
    private String address;
    private String tel;
    private String email;
    private String url;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SaxContacts{" +
                "address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaxContacts that = (SaxContacts) o;
        return Objects.equals(address, that.address) && Objects.equals(tel, that.tel)
                && Objects.equals(email, that.email) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, tel, email, url);
    }
}
