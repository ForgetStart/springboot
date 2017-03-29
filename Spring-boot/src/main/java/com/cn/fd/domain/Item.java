/**
 * 
 */
package com.cn.fd.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * <p> Description: 
 * 		商品实体类
 * 	</p>
 * @author fengda
 * @date 2017年3月13日 下午2:06:42
 */
@Entity
@Table(name="tb_item")
public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
 	private Long id;

	@Column(nullable=false)
	private String title;
	
	//商品卖点
	@Column(name="sell_point")
	private String sellPoint;
	
	@Column(nullable=false)
	private long price;
	
	@Column(nullable=false)
	private Integer num;
	
	//商品条形码
	private String barcode;
	
	private String image;
	
	@Column(nullable=false)
	private Long cid;
	
	@Column(nullable=false)
	private Integer status;
	
	@Column(nullable=false)
	private Date created;
	
	@Column(nullable=false)
	private Date updated;

	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", sellPoint="
				+ sellPoint + ", price=" + price + ", num=" + num
				+ ", barcode=" + barcode + ", image=" + image + ", cid=" + cid
				+ ", status=" + status + ", created=" + created + ", updated="
				+ updated + "]";
	}

	public Item() {
		super();
	}
	
	public Item(Long id, String title, String sellPoint, long price,
			Integer num, String barcode, String image, Long cid,
			Integer status, Date created, Date updated) {
		super();
		this.id = id;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.num = num;
		this.barcode = barcode;
		this.image = image;
		this.cid = cid;
		this.status = status;
		this.created = created;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
