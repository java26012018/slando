package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Table(name = "slando_item")
@Entity
public class Item {
    @Id
    private String id;
    private String cat;
    private String name;
    private String about;
    private String pic;
    private String owner;
    private String phone;
    private String email;
    private String city;
    private int price;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "is_vip")
    private boolean isVip;

    public Item() {
    }

    public Item(String id, String cat, String name, String about, String pic, String owner, String phone, String email, String city, int price, Date createDate, boolean isVip) {
        this.id = id;
        this.cat = cat;
        this.name = name;
        this.about = about;
        this.pic = pic;
        this.owner = owner;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.price = price;
        this.createDate = createDate;
        this.isVip = isVip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price &&
                isVip == item.isVip &&
                Objects.equals(id, item.id) &&
                Objects.equals(cat, item.cat) &&
                Objects.equals(name, item.name) &&
                Objects.equals(about, item.about) &&
                Objects.equals(pic, item.pic) &&
                Objects.equals(owner, item.owner) &&
                Objects.equals(phone, item.phone) &&
                Objects.equals(email, item.email) &&
                Objects.equals(city, item.city) &&
                Objects.equals(createDate, item.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cat, name, about, pic, owner, phone, email, city, price, createDate, isVip);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id='").append(id).append('\'');
        sb.append(", cat='").append(cat).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", about='").append(about).append('\'');
        sb.append(", pic='").append(pic).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", price=").append(price);
        sb.append(", createDate=").append(createDate);
        sb.append(", isVip=").append(isVip);
        sb.append('}');
        return sb.toString();
    }
}
