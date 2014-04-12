package org.rontai.s.menu.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "S_MENU_MENUNODE")
public class MenuNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8991390832606372727L;

	/**
	 * DB ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/**
	 * resource code
	 */
	@Column(name = "CODE")
	private String code;

	/**
	 * sub nodes
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_CODE", referencedColumnName = "CODE")
	private MenuNode parent;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MenuNode> subNodes;

	/**
	 * contained menu
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MENU_CODE", referencedColumnName = "CODE")
	private Menu menu;

	/**
	 * whether it is the bottom node
	 */
	@Column(name = "BTM_NODE")
	private Boolean btmNode;

	/**
	 * whether it is the head node
	 */
	@Column(name = "HEAD_NODE")
	private Boolean headNode;
	
	@Column(name = "LABEL")
	private String label;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MenuNode getParent() {
		return parent;
	}

	public void setParent(MenuNode parent) {
		this.parent = parent;
	}

	public List<MenuNode> getSubNodes() {
		return subNodes;
	}

	public void setSubNodes(List<MenuNode> subNodes) {
		this.subNodes = subNodes;
		for(MenuNode n : subNodes){
			n.setParent(this);
		}
	}
	
	public void addSubNode(MenuNode subNode){
		this.subNodes.add(subNode);
		subNode.setParent(this);
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
		this.label = menu.getLabel();
	}

	public Boolean getBtmNode() {
		return btmNode;
	}

	public void setBtmNode(Boolean btmNode) {
		this.btmNode = btmNode;
	}

	public Boolean getHeadNode() {
		return headNode;
	}

	public void setHeadNode(Boolean headNode) {
		this.headNode = headNode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(code).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof MenuNode)) {
			return false;
		}
		MenuNode o = (MenuNode) obj;
		return new EqualsBuilder().append(code, o.code).isEquals();
	}
	
	@Override
	public String toString() {
		return this.getLabel();
	}
}
