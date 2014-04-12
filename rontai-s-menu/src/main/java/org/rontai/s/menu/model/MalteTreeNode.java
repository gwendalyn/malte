package org.rontai.s.menu.model;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

public class MalteTreeNode extends DefaultTreeNode {

	private static final long serialVersionUID = -2859729569949007953L;

	private String label;

	
	
	public MalteTreeNode(String label, Object data, TreeNode parent) {
		super(data,parent);
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return label;
	}
	
}
